<?php

use Zipkin\Propagation\Map;

header("Content-type: application/json");

require  '../../vendor/autoload.php';
require '../../functions.php';

$tracing = create_tracing('Wurth-Pimcore', '0.0.0.0');

$request = \Symfony\Component\HttpFoundation\Request::createFromGlobals();

$carrier = array_map(function ($header) {
  return $header[0];
}, $request->headers->all());

/* Extracts the context from the HTTP headers */
$extractor = $tracing->getPropagation()->getExtractor(new Map());
$extractedContext = $extractor($carrier);

$tracer = $tracing->getTracer();
$span = $tracer->nextSpan($extractedContext);
$span->start();
$span->setKind(Zipkin\Kind\SERVER);
$span->setName('Pimcore:findProductsBySkus');

$response = searchForProducts();

$span->finish();

echo $response;

function searchForProducts()
{

  sleep(rand(1,3));

  $allProducts = json_decode(file_get_contents("../products.json"));
  $filteredProducts = [];

  if (isset($_REQUEST["bySkus"])) {
    $skuIds = explode(',', $_REQUEST["bySkus"]);

    foreach ($allProducts as $idx => $product) {
      if (in_array($product->sku, $skuIds)) {
        $filteredProducts[] = $product;
      }
    }
  } else {
    $filteredProducts = $allProducts;
  }

  return json_encode(array("products" => $filteredProducts));
}


/* Sends the trace to zipkin once the response is served */
register_shutdown_function(function () use ($tracer) {
  $tracer->flush();
});
