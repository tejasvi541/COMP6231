package com.comp6231.fruit_month_price.service;

import com.comp6231.fruit_month_price.model.FruitPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FruitPriceService {

    @Autowired
    private FruitPriceRepository fruitPriceRepository;

    public FruitPrice getFruitPrice(String fruit, String month) {
        Optional<FruitPrice> optionalFruitPrice = fruitPriceRepository.findById(fruit);
        if (!optionalFruitPrice.isPresent()) {
            throw new IllegalArgumentException("No price found for " + fruit);
        }
        FruitPrice fruitPrice = optionalFruitPrice.get();
        double price;
        switch (month.toLowerCase()) {
            case "jan":
                price = fruitPrice.getJan();
                break;
            case "feb":
                price = fruitPrice.getFeb();
                break;
            case "mar":
                price = fruitPrice.getMar();
                break;
            case "apr":
                price = fruitPrice.getApr();
                break;
            case "may":
                price = fruitPrice.getMay();
                break;
            case "jun":
                price = fruitPrice.getJun();
                break;
            case "jul":
                price = fruitPrice.getJul();
                break;
            case "aug":
                price = fruitPrice.getAug();
                break;
            case "sep":
                price = fruitPrice.getSep();
                break;
            case "oct":
                price = fruitPrice.getOct();
                break;
            case "nov":
                price = fruitPrice.getNov();
                break;
            case "dec":
                price = fruitPrice.getDec();
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
        return new FruitPrice(fruit, month, price);
    }
}
