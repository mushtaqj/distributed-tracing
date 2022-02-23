<?php

header("Content-type: application/json");

$products = json_decode(file_get_contents("products.json"));

echo json_encode(array('products' => $products));
