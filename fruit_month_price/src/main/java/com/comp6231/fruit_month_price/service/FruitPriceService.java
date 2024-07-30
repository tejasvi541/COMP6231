package com.comp6231.fruit_month_price.service;

import com.comp6231.fruit_month_price.model.FruitPrice;
import com.comp6231.fruit_month_price.repository.FruitPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FruitPriceService {

    private final FruitPriceRepository fruitPriceRepository;

    @Autowired
    public FruitPriceService(FruitPriceRepository fruitPriceRepository) {
        this.fruitPriceRepository = fruitPriceRepository;
    }

    public double getFruitPrice(String fruit, String month) {
        Optional<FruitPrice> optionalFruitPrice = fruitPriceRepository.findById(fruit);
        if (optionalFruitPrice.isEmpty()) {
            throw new IllegalArgumentException("No price found for " + fruit);
        }
        FruitPrice fruitPrice = optionalFruitPrice.get();
        return fruitPrice.getPriceForMonth(month);
    }
}

