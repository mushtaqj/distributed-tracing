package com.wurthlac.elasticpath.controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import lk.wurthlac.models.EPOrder;
import lk.wurthlac.models.ESBOrder;
import lk.wurthlac.models.LineItemWithProduct;
import lk.wurthlac.models.ProductsList;
import lk.wurthlac.models.abs.LineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrdersController
{
  private static final String PIM_SEARCH = "http://localhost:8000/products/search?bySkus={bySkus}";
  private static final String ESB_HOP =  "http://localhost:3000/checkout";

  private final RestTemplate restTemplate;

  @Autowired
  public OrdersController (final RestTemplate restTemplate)
  {
    this.restTemplate = restTemplate;
  }

  @PostMapping("/create")
  public ESBOrder createOrder (@RequestBody final EPOrder order)
  {
    final ESBOrder esbOrder = mapToESBOrder(order);

    return restTemplate.postForObject(ESB_HOP, esbOrder, ESBOrder.class);
  }

  private ESBOrder mapToESBOrder (final EPOrder epOrder)
  {
    final Map<String, Integer> productSkus =
      epOrder.getLineItems().stream().collect(Collectors.toMap(LineItem::getProduct, LineItem::getQuantity));

    final String[] productSkuKeys = new ArrayList<>(productSkus.keySet()).toArray(new String[0]);
    final ProductsList productsList = restTemplate.getForObject(PIM_SEARCH,
                                                                ProductsList.class,
                                                                String.join(",", productSkuKeys));
    final ESBOrder order = new ESBOrder();
    order.setPayment(epOrder.getPayment());

    Objects.requireNonNull(productsList).getProducts().forEach(product -> {
      final Integer quantity = productSkus.get(product.getSku());
      final LineItemWithProduct lineItem = new LineItemWithProduct();
      lineItem.setProduct(product);
      lineItem.setQuantity(quantity);
      order.getLineItems().add(lineItem);
    });

    return order;
  }
}
