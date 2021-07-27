package com.meli.storeapi.services;

import com.meli.storeapi.dtos.ProductDTO;
import com.meli.storeapi.entities.Product;
import com.meli.storeapi.forms.ProductForm;
import com.meli.storeapi.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductForm productForm) {
        Product product = new Product(productForm.getDescription(),
                productForm.getColor(),
                productForm.getQuantity(),
                productForm.getPrice());
        this.productRepository.addProduct(product);
        return ProductDTO.toDTO(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = this.productRepository.getAllProducts();
        return products.stream().map(ProductDTO::toDTO).collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long productId) {
        Product product = this.productRepository.getProductById(productId);
        return ProductDTO.toDTO(product);
    }

    public ProductDTO updateProduct(Long productId, ProductForm productForm) {
        Product product = this.productRepository.getProductById(productId);
        product.setColor(productForm.getColor());
        product.setPrice(productForm.getPrice());
        product.setQuantity(productForm.getQuantity());
        product.setDescription(productForm.getDescription());
        this.productRepository.updateProduct(productId, product);
        return ProductDTO.toDTO(product);
    }

    public void deleteProduct(Long productId) {
        this.productRepository.deleteProduct(productId);
    }
}
