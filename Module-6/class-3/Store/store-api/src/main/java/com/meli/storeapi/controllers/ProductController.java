package com.meli.storeapi.controllers;

import com.meli.storeapi.dtos.ProductDTO;
import com.meli.storeapi.forms.ProductForm;
import com.meli.storeapi.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductForm productForm) {
        return this.productService.createProduct(productForm);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("{productId}")
    public ProductDTO getProduct(@PathVariable Long productId) {
        return this.productService.getProductById(productId);
    }

    @PutMapping("{productId}")
    public ProductDTO updateProduct(@PathVariable Long productId, @RequestBody ProductForm productForm) {
        return this.productService.updateProduct(productId, productForm);
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        this.productService.deleteProduct(productId);
    }
}
