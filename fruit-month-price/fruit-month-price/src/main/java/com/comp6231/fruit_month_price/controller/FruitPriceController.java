package com.comp6231.fruit_month_price.controller;
import com.comp6231.fruit_month_price.model.FruitPrice;
import com.comp6231.fruit_month_price.service.FruitPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitPriceController {

    @Autowired
    private FruitPriceService fruitPriceService;

    @GetMapping("/fruit-month-price/fruit/{fruit}/month/{month}")
    public FruitPrice getFruitPrice(@PathVariable String fruit, @PathVariable String month) {
        return fruitPriceService.getFruitPrice(fruit, month);
    }

    @GetMapping("/total-fruit-price/fruit/{fruit}/month/{month}/quantity/{quantity}")
    public TotalFruitPrice getTotalFruitPrice(@PathVariable String fruit, @PathVariable String month, @PathVariable int quantity) {
        double price = fruitPriceService.getFruitPrice(fruit, month).getPrice();
        return new TotalFruitPrice(fruit, month, quantity, price * quantity);
    }
}
