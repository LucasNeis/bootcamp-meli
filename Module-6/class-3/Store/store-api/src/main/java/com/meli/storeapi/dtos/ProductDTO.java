package com.meli.storeapi.dtos;

import com.meli.storeapi.entities.Product;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String description;
    private String color;
    private Integer quantity;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String description, String color, Integer quantity, BigDecimal price) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static ProductDTO toDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getDescription(),
                product.getColor(),
                product.getQuantity(),
                product.getPrice());
    }
}
