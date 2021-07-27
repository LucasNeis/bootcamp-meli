package com.meli.exercise1.services;

import com.meli.exercise1.DTOs.OrderDTO;
import com.meli.exercise1.DTOs.TableDTO;
import com.meli.exercise1.Forms.DishForm;
import com.meli.exercise1.Forms.OrderForm;
import com.meli.exercise1.entities.Dish;
import com.meli.exercise1.entities.Order;
import com.meli.exercise1.entities.Table;
import com.meli.exercise1.exceptions.ImpossibleToAccessException;
import com.meli.exercise1.exceptions.ResourceNotFoundException;
import com.meli.exercise1.repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderService {
    private final TableRepository tableRepository;
    private final RestaurantService restaurantService;

    public OrderService(TableRepository tableRepository, RestaurantService restaurantService) {
        this.tableRepository = tableRepository;
        this.restaurantService = restaurantService;
    }

    public TableDTO getTable(Long id, boolean inclusive) throws ImpossibleToAccessException {
        Table table = this.tableRepository.getTableById(id);
        return TableDTO.toDTO(table, inclusive);
    }

    public TableDTO createTable() {
        Table table = new Table();
        this.tableRepository.createTable(table);
        return TableDTO.toDTO(table, false);
    }

    public void deleteTable(Long tableId) {
        this.tableRepository.deleteTableById(tableId);
    }

    public TableDTO addOrderToTable(Long tableId, OrderForm orderForm) {
        Table table = this.tableRepository.getTableById(tableId);
        List<Long> dishIds = orderForm.getDishes();
        List<Dish> dishes = dishIds.stream()
                .map(this.restaurantService::FindDishById)
                .map(Optional::get)
                .collect(Collectors.toList());
        Optional<BigDecimal> optionalTotal = dishes.stream()
                .map(Dish::getPrice)
                .reduce(BigDecimal::add);

        BigDecimal total = optionalTotal.orElseGet(() -> new BigDecimal("0.00"));
        Order order = new Order(dishes, total);
        table.addOrder(order);
        this.tableRepository.save(table);
        return TableDTO.toDTO(table, false);
    }

    public List<OrderDTO> getAllOrdersFromTable(Long tableId, boolean inclusive, LocalDate now) {
        Stream<Order> orders = this.tableRepository.getTableById(tableId)
                .getOrders()
                .stream()
                .filter(x -> this.checkIfDateWithinDay(x.getTime(), now));
        if (!inclusive)
            orders = orders.filter(Order::isActive);

        return orders.map(OrderDTO::toDTO)
                .collect(Collectors.toList());
    }

    public List<TableDTO> getAllTables(boolean inclusive) {
        List<Table> tables = this.tableRepository.getAllTables();
        return tables.stream()
                .map(x -> new TableDTO(
                        x.getId(),
                        this.getAllOrdersFromTable(x.getId(), inclusive, LocalDate.now())))
                .collect(Collectors.toList());
    }

    public void deleteOrderFromTable(Long tableId, Long orderId) {
        Table table = this.tableRepository.getTableById(tableId);
        Order order = this.findOrderByIdOrElseThrow(tableId, orderId);
        table.deleteOrder(order);
        this.tableRepository.save();
    }

    public Optional<Order> findOrderById(Long tableId, Long orderId) {
        Table table = this.tableRepository.getTableById(tableId);
        return table.getOrders()
                .stream()
                .filter(x -> x.getId().equals(orderId)).findFirst();
    }

    private Order findOrderByIdOrElseThrow(Long tableId, Long orderId) {
        return this.findOrderById(tableId, orderId).orElseThrow(() ->
                new ResourceNotFoundException("Order with ID " + orderId +
                        " does not exist on table with ID " + tableId + "."));
    }

    public OrderDTO getOrderById(Long tableId, Long orderId) {
        Order order = findOrderByIdOrElseThrow(tableId, orderId);
        return OrderDTO.toDTO(order);
    }

    public OrderDTO addDishToOrder(Long tableId, Long orderId, DishForm form) {
        Order order = this.findOrderByIdOrElseThrow(tableId, orderId);
        Dish dish = new Dish(form.getDescription(), form.getQuantity(), form.getPrice());
        order.addDish(dish);
        this.tableRepository.save();
        return OrderDTO.toDTO(order);
    }

    public void deleteDishFromOrder(Long tableId, Long orderId, Long dishId) {
        Order order = this.findOrderByIdOrElseThrow(tableId, orderId);
        Dish dish = order.getDishes()
                .stream()
                .filter(x -> x.getId().equals(dishId))
                .findAny()
                .orElseThrow(() ->
                        new ResourceNotFoundException("No Dish with ID " + dishId +
                                " on Order with ID " + orderId +
                                " from Table with ID " + tableId + "."));
        order.removeDish(dish);
    }

    private boolean checkIfDateWithinDay(LocalDateTime date, LocalDate day) {
        return date.isAfter(day.atStartOfDay()) &&
                date.isBefore(day.plusDays(1).atStartOfDay());
    }
}
