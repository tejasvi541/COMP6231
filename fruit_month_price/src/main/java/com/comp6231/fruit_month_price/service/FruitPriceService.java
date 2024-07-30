package com.comp6231.fruit_month_price.service;

import com.comp6231.fruit_month_price.model.FruitPrice;
import com.comp6231.fruit_month_price.repository.FruitPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitPriceService {

    private final FruitPriceRepository fruitPriceRepository;

    @Autowired
    public FruitPriceService(FruitPriceRepository fruitPriceRepository) {
        this.fruitPriceRepository = fruitPriceRepository;
    }

    public double getFruitPrice(String fruit, String month) {
        FruitPrice fruitPrice = fruitPriceRepository.findByFruit(fruit);
        if (fruitPrice == null) {
            throw new IllegalArgumentException("Fruit not found: " + fruit);
        }
        return fruitPrice.getPriceForMonth(month);
    }

    public FruitPrice getFruitPriceEntity(String fruit, String month) {
        FruitPrice fruitPrice = fruitPriceRepository.findByFruit(fruit);
        if (fruitPrice == null) {
            throw new IllegalArgumentException("Fruit not found: " + fruit);
        }
        double price = fruitPrice.getPriceForMonth(month);
        return new FruitPrice(fruitPrice.getId(), fruit, month, price);
    }
}
