package com.comp6231.fruit_month_price.repository;

import com.comp6231.fruit_month_price.model.FruitPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitPriceRepository extends JpaRepository<FruitPrice, String> {}
