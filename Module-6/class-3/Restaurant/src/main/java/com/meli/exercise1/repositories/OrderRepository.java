package com.meli.exercise1.repositories;

import com.meli.exercise1.entities.Order;
import com.meli.exercise1.exceptions.ImpossibleToAccessException;
import com.meli.exercise1.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import javax.management.InstanceNotFoundException;
import java.util.Optional;

@Repository
public class OrderRepository {

    private final RestaurantRepository restaurantRepository;

    public OrderRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Order getOrderById(Long id) throws InstanceNotFoundException, ImpossibleToAccessException {
        return this.restaurantRepository.getOrderById(id);
    }

    public Optional<Order> findOrderById(Long id) throws ImpossibleToAccessException {
        Optional<Order> found;
        try {
            found = Optional.of(this.getOrderById(id));
        } catch (InstanceNotFoundException ex) {
            found = Optional.empty();
        }
        return found;
    }

    public Order addOrder(Long tableId, Order order) throws ImpossibleToAccessException {
        return this.restaurantRepository.addOrder(tableId, order);
    }

    public void deleteOrder(Long tableId, Order order) throws ImpossibleToAccessException {
        this.restaurantRepository.deleteOrder(tableId, order);
    }

    public void deleteOrderById(Long tableid, Long id) throws ResourceNotFoundException, ImpossibleToAccessException {
        Optional<Order> order = this.findOrderById(id);
        if (order.isEmpty()) {
            throw new ResourceNotFoundException("No order with ID " + id + " found.");
        }
        this.restaurantRepository.deleteOrder(tableid, order.get());
    }
}
