package com.Product_Angular.Services;



import org.springframework.stereotype.Service;

import com.Product_Angular.Entities.Product;
import com.Product_Angular.Exceptions.ResourceNotFoundException;
import com.Product_Angular.Repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
	
	
    private final ProductRepository repo;
    
    public ProductService(ProductRepository repo) { this.repo = repo; }

    public List<Product> findAll() { return repo.findAll(); }
    public Product findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found: " + id));
    }
    public Product create(Product p) { return repo.save(p); }
    public Product update(Long id, Product p) {
        Product existing = findById(id);
        existing.setName(p.getName());
        existing.setDescription(p.getDescription());
        existing.setPrice(p.getPrice());
        return repo.save(existing);
    }
    public void delete(Long id) { repo.delete(findById(id)); }
}

