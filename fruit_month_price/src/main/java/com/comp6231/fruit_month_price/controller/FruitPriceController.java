package com.comp6231.fruit_month_price.controller;


import com.comp6231.fruit_month_price.model.FruitPrice;
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
    public FruitPrice getFruitPrice(@PathVariable String fruit, @PathVariable String month) {
        double price = fruitPriceService.getFruitPrice(fruit, month);
        return new FruitPrice(fruit, month, price);
    }
}

