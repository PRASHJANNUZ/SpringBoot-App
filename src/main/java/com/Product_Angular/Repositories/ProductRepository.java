package com.Product_Angular.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Product_Angular.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
