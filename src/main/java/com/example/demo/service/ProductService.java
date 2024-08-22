package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductSpecification;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(String name, String brand, String category, BigDecimal minPrice, BigDecimal maxPrice, Integer minQuantity, Integer maxQuantity) {
        Specification<Product> spec = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            spec = spec.and(ProductSpecification.hasName(name));
        }
        if (brand != null && !brand.isEmpty()) {
            spec = spec.and(ProductSpecification.hasBrand(brand));
        }
        if (category != null && !category.isEmpty()) {
            spec = spec.and(ProductSpecification.hasCategory(category));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpecification.hasPriceGreaterThanOrEqualTo(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecification.hasPriceLessThanOrEqualTo(maxPrice));
        }
        if (minQuantity != null) {
            spec = spec.and(ProductSpecification.hasQuantityGreaterThanOrEqualTo(minQuantity));
        }
        if (maxQuantity != null) {
            spec = spec.and(ProductSpecification.hasQuantityLessThanOrEqualTo(maxQuantity));
        }

        return productRepository.findAll(spec);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            return null;
        }
    }
    

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    public List<Product> searchProductsName(String name) {   // Added search function
        Specification<Product> spec = ProductSpecification.hasName(name);
        return productRepository.findAll(spec);
    }
    
}
