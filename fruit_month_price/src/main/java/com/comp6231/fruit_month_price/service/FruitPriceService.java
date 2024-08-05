package com.comp6231.fruit_month_price.service;

import com.comp6231.fruit_month_price.dto.FruitPriceDto;
import com.comp6231.fruit_month_price.model.FruitPrice;
import com.comp6231.fruit_month_price.repository.FruitPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class FruitPriceService {

    private final FruitPriceRepository fruitPriceRepository;
    private Environment environment;

    String port;

    @Autowired
    public FruitPriceService(FruitPriceRepository fruitPriceRepository, Environment environment) {
        this.fruitPriceRepository = fruitPriceRepository;
        this.environment = environment;
        this.port = environment.getProperty("server.port");
    }

    public FruitPriceDto getFruitPriceEntity(String fruit, String month) {
        FruitPrice fruitPrice = fruitPriceRepository.findByFruit(fruit);
        if (fruitPrice == null) {
            throw new IllegalArgumentException("Fruit not found: " + fruit);
        }
        double price = fruitPrice.getPriceForMonth(month);
        return new FruitPriceDto(fruitPrice.getId(), fruit, month, price, port);
    }
}
