package com.comp6231.fruit_month_price_quantity.service;

import com.comp6231.fruit_month_price_quantity.dto.FruitPriceConversionDto;
import com.comp6231.fruit_month_price_quantity.dto.FruitPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FruitPriceQuantityService {
  private final RestTemplate restTemplate;
  private Environment environment;

  private String port;
  @Autowired
  public FruitPriceQuantityService(RestTemplate restTemplate, Environment environment) {
    this.restTemplate = restTemplate;
    this.environment = environment;
    this.port = environment.getProperty("server.port");
  }
  public FruitPriceDto getFruitPriceByMonth(String fruit, String month) {
    String url = String.format("http://localhost:8080/fruit-month-price/fruit/%s/month/%s", fruit, month);
    return restTemplate.getForObject(url, FruitPriceDto.class);
  }

  public FruitPriceConversionDto getQuantityFruitPriceByMonth(String fruit, String month, int quantity) {
    FruitPriceDto fruitPriceDto = getFruitPriceByMonth(fruit, month);
    double pricePerUnit = fruitPriceDto.getPrice();
    double totalPrice = pricePerUnit * quantity;
    return new FruitPriceConversionDto(fruitPriceDto.getId(),fruit, month, pricePerUnit, quantity, totalPrice, port);
  }
}
