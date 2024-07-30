package com.comp6231.fruit_month_price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(scanBasePackages = "com.comp6231.fruit_month_price")
@EnableJpaRepositories(basePackages = "com.comp6231.fruit_month_price.repository")
public class FruitMonthPriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitMonthPriceApplication.class, args);
	}

}
