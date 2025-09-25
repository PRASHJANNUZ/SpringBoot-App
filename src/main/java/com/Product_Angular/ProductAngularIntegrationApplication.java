package com.Product_Angular;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Product_Angular.Entities.Product;
import com.Product_Angular.Repositories.ProductRepository;

@SpringBootApplication
public class ProductAngularIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAngularIntegrationApplication.class, args);
		System.out.println("Angular App Started....");
	}

	@Bean
	CommandLineRunner runner(ProductRepository repo) {
	  return args -> {
	    repo.save(new Product("Apple", "Fresh red apple", new BigDecimal("0.99")));
	    repo.save(new Product("Laptop", "14 inch laptop", new BigDecimal("799.00")));
	  };
	}

}
