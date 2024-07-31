package com.comp6231.fruit_month_price_quantity.controller;

import com.comp6231.fruit_month_price_quantity.dto.FruitPriceConversionDto;
import com.comp6231.fruit_month_price_quantity.dto.FruitPriceDto;
import com.comp6231.fruit_month_price_quantity.service.FruitPriceQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitPriceQuantityController {
  private final FruitPriceQuantityService fruitPriceQuantityService;

  @Autowired
  public FruitPriceQuantityController(FruitPriceQuantityService fruitPriceQuantityService) {
    this.fruitPriceQuantityService = fruitPriceQuantityService;
  }
  @GetMapping("/fruit-month-price/fruit/{fruit}/month/{month}/quantity/{quantity}")
  public FruitPriceConversionDto getQuantityFruitPrice(@PathVariable String fruit, @PathVariable String month,
      @PathVariable double quantity) {
    return fruitPriceQuantityService.getQuantityFruitPriceByMonth(fruit, month, (int) quantity);
  }
}
