package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product("Product1", "Brand1", "Description of Product1", BigDecimal.valueOf(100.00), 10, "Category1");
        product.setId(1L);
    }

    @Test
    public void testCreateProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product createdProduct = productService.createProduct(product);

        assertNotNull(createdProduct);
        assertEquals("Product1", createdProduct.getName());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testGetProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<Product> foundProduct = productService.getProductById(1L);

        assertTrue(foundProduct.isPresent());
        assertEquals("Product1", foundProduct.get().getName());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdateProduct() {
        // Arrange
        when(productRepository.existsById(1L)).thenReturn(true);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Act
        Product updatedProduct = productService.updateProduct(1L, product);

        // Assert
        assertNotNull(updatedProduct, "Updated product should not be null");
        assertEquals(product.getId(), updatedProduct.getId(), "Product ID should match");
        assertEquals(product.getName(), updatedProduct.getName(), "Product name should match");
        assertEquals(product.getBrand(), updatedProduct.getBrand(), "Product brand should match");
        assertEquals(product.getDescription(), updatedProduct.getDescription(), "Product description should match");
        assertEquals(product.getPrice(), updatedProduct.getPrice(), "Product price should match");
        assertEquals(product.getQuantity(), updatedProduct.getQuantity(), "Product quantity should match");
        assertEquals(product.getCategory(), updatedProduct.getCategory(), "Product category should match");

        verify(productRepository, times(1)).existsById(1L);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    public void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
}
