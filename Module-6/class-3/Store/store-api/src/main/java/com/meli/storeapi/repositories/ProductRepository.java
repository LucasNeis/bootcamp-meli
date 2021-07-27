package com.meli.storeapi.repositories;

import com.meli.storeapi.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private final StoreRepository storeRepository;

    public ProductRepository(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void addProduct(Product product) {
        this.storeRepository.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return this.storeRepository.getAllProducts();
    }

    public Product getProductById(Long productId) {
        return this.storeRepository.getProductById(productId);
    }

    public void updateProduct(Long productId, Product product) {
        this.storeRepository.updateProduct(productId, product);
    }

    public void deleteProduct(Long productId) {
        this.storeRepository.deleteProduct(productId);
    }
}
