package com.comp6231.fruit_month_price.controller;

import com.comp6231.fruit_month_price.dto.FruitPriceDto;
import com.comp6231.fruit_month_price.service.FruitPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitPriceController {

    private final FruitPriceService fruitPriceService;

    @Autowired
    public FruitPriceController(FruitPriceService fruitPriceService) {
        this.fruitPriceService = fruitPriceService;
    }

    @GetMapping("/fruit-month-price/fruit/{fruit}/month/{month}")
    public FruitPriceDto getFruitPrice(@PathVariable String fruit, @PathVariable String month) {
        return fruitPriceService.getFruitPriceEntity(fruit, month);
    }
}
