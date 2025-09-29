package com.Product_Angular.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Product_Angular.Entities.Product;
import com.Product_Angular.Services.ProductService;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200") // allow Angular dev server
public class ProductController {
	
	@Autowired
	private Logger logger;
	
	
	
    private final ProductService service;
    
    public ProductController(ProductService service) {
    	this.service = service; 
    }

    @GetMapping
    public List<Product> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) { 
    	
    	logger.info("Hi, Prashant GetByID Method Executing, CI/CD Changes Affected....!");
    	return service.findById(id); 
    	
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product p) {
        Product created = service.create(p);
        return ResponseEntity.created(URI.create("/api/products/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p) { return service.update(id, p); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

