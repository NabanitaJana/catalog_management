package com.example.demo.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.Product;

public class ProductSpecification {
    public static Specification<Product> hasName(String name) {
        return (product, cq, cb) -> cb.like(cb.lower(product.get("name")), "%" + name.toLowerCase() + "%");
        

    }

    public static Specification<Product> hasBrand(String brand) {
        return (product, cq, cb) -> cb.like(cb.lower(product.get("brand")), "%" + brand.toLowerCase() + "%");
    }

    public static Specification<Product> hasCategory(String category) {
        return (product, cq, cb) -> cb.like(cb.lower(product.get("category")), "%" + category.toLowerCase() + "%");
    }

    public static Specification<Product> hasPriceGreaterThanOrEqualTo(BigDecimal price) {
        return (product, cq, cb) -> cb.greaterThanOrEqualTo(product.get("price"), price);
    }

    public static Specification<Product> hasPriceLessThanOrEqualTo(BigDecimal price) {
        return (product, cq, cb) -> cb.lessThanOrEqualTo(product.get("price"), price);
    }

    public static Specification<Product> hasQuantityGreaterThanOrEqualTo(Integer quantity) {
        return (product, cq, cb) -> cb.greaterThanOrEqualTo(product.get("quantity"), quantity);
    }

    public static Specification<Product> hasQuantityLessThanOrEqualTo(Integer quantity) {
        return (product, cq, cb) -> cb.lessThanOrEqualTo(product.get("quantity"), quantity);
    }
}
