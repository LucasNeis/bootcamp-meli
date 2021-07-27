package com.meli.storeapi.dtos;

import com.meli.storeapi.entities.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {
    private Long id;
    private List<ProductDTO> products = new ArrayList<>();
    private BigDecimal total;

    public OrderDTO() {
    }

    public OrderDTO(Long id, List<ProductDTO> products, BigDecimal total) {
        this.id = id;
        this.products = products;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public static OrderDTO toDTO(Order order) {
        List<ProductDTO> productDTOS = order.getProducts()
                .stream()
                .map(ProductDTO::toDTO)
                .collect(Collectors.toList());
        return new OrderDTO(order.getId(), productDTOS, order.getTotal());
    }
}
