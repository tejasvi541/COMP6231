package com.comp6231.fruit_month_price.service;

import com.comp6231.fruit_month_price.model.FruitPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FruitPriceService {

    @Autowired
    private FruitPriceRepository fruitPriceRepository;

    public double getFruitPrice(String fruit, String month) {
        Optional<FruitPrice> optionalFruitPrice = fruitPriceRepository.findById(fruit);
        if (!optionalFruitPrice.isPresent()) {
            throw new IllegalArgumentException("No price found for " + fruit);
        }
        FruitPrice fruitPrice = optionalFruitPrice.get();
        return switch (month.toLowerCase()) {
            case "jan" -> fruitPrice.getJan();
            case "feb" -> fruitPrice.getFeb();
            case "mar" -> fruitPrice.getMar();
            case "apr" -> fruitPrice.getApr();
            case "may" -> fruitPrice.getMay();
            case "jun" -> fruitPrice.getJun();
            case "jul" -> fruitPrice.getJul();
            case "aug" -> fruitPrice.getAug();
            case "sep" -> fruitPrice.getSep();
            case "oct" -> fruitPrice.getOct();
            case "nov" -> fruitPrice.getNov();
            case "dec" -> fruitPrice.getDec();
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };
    }
}
