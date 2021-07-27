package com.meli.exercise1.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.exercise1.entities.*;
import com.meli.exercise1.exceptions.ImpossibleToAccessException;
import com.meli.exercise1.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Repository
public class RestaurantRepository {
    private Restaurant restaurant;
    private final ObjectMapper mapper;
    private final String dataBasePath = "src/main/resources/data/database.json";

    public RestaurantRepository() throws ImpossibleToAccessException {
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            if (Files.exists(Path.of(dataBasePath))) {
                this.load();
            } else {
                this.restaurant = new Restaurant();
                this.save();
            }
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }

    public Map<Long, Table> getTables() throws ImpossibleToAccessException {
        this.load();
        return this.restaurant.getHall().getTables();
    }

    public Table addTable(Table table) throws ImpossibleToAccessException {
        this.load();
        this.restaurant.getHall().addTable(table);
        this.save();
        return table;
    }

    public Table getTableById(Long id) throws ImpossibleToAccessException {
        this.load();
        Hall restaurantHall = this.restaurant.getHall();
        if (restaurantHall.tableExists(id)) {
            return restaurantHall.getTableById(id);
        }
        throw new ImpossibleToAccessException("Table with ID " + id + " not found.");
    }

    private void load() throws ImpossibleToAccessException {
        try {
            File data = new File(dataBasePath);
            this.restaurant = mapper.readValue(data, Restaurant.class);
            this.updateUniversalIds();
        } catch (IOException ex) {
            throw new ImpossibleToAccessException(ex.getMessage());
        }
    }

    private void updateUniversalIds() {
        if (!this.restaurant.getMenu().isEmpty())
            this.updateDishUniversalId();
        if (this.restaurant.getHall().doesAnyTableHaveOrders())
            this.updateOrderUniversalId();
        if (!this.restaurant.getHall().getTables().isEmpty())
            this.updateTableUniversalId();
    }

    private void updateDishUniversalId() {
        Optional<Long> max = this.restaurant.getMenu()
                .stream()
                .map(Dish::getId)
                .max(Long::compare);
        Long value = this.decideUniversalId(max);
        Dish.setUniversalId(value);
    }
    private void updateTableUniversalId() {
        Collection<Table> tables = this.restaurant.getHall().getTables().values();
        Optional<Long> max = tables.stream().map(Table::getId).max(Long::compare);
        Long value = this.decideUniversalId(max);
        Table.setUniversalId(value);
    }

    private void updateOrderUniversalId() {
        List<Order> orders = new ArrayList<>();
        Collection<Table> tables = this.restaurant.getHall().getTables().values();
        tables.forEach(x -> orders.addAll(x.getOrders()));
        Optional<Long> max = orders.stream().map(Order::getId).max(Long::compare);
        Long value = this.decideUniversalId(max);
        Order.setUniversalId(value);
    }


    private Long decideUniversalId(Optional<Long> foundId) {
        return foundId.isEmpty() ? 0 : foundId.get()+1;
    }

    public void save() throws ImpossibleToAccessException {
        try {
            String result = mapper.writeValueAsString(this.restaurant);
            BufferedWriter writer = new BufferedWriter(new FileWriter(dataBasePath));
            writer.write(result);
            writer.close();
        } catch (IOException ex) {
            throw new ImpossibleToAccessException(ex.getMessage());
        }
        this.load();
    }

    public void deleteTable(Table table) throws ImpossibleToAccessException {
        this.load();
        this.restaurant.getHall().deleteTable(table);
        this.save();
    }

    public Order getOrderById(Long id) {
        this.load();
        Hall hall = this.restaurant.getHall();
        Order found = hall.getOrderById(id);
        if (Objects.nonNull(found)) {
            return found;
        }
        throw new ImpossibleToAccessException("Order with ID " + id + " not found.");
    }

    public Order addOrder(Long tableId, Order order) throws ImpossibleToAccessException {
        this.load();
        Hall hall = this.restaurant.getHall();
        hall.getTable(tableId).addOrder(order);
        this.save();
        return order;
    }

    public void deleteOrder(Long tableId, Order order) throws ImpossibleToAccessException {
        this.load();
        Hall hall = this.restaurant.getHall();
        Table table = hall.getTable(tableId);
        table.deleteOrder(order);
        this.save();
    }

    public Cashier getCashier() throws ImpossibleToAccessException {
        this.load();
        return this.restaurant.getCashier();
    }

    public List<Table> getAllTables() {
        this.load();
        return new ArrayList<>(this.restaurant.getHall().getTables().values());
    }

    public Dish addDish(Dish dish) {
        this.load();
        this.restaurant.getMenu().add(dish);
        this.save();
        return dish;
    }

    public List<Dish> getAllDishes() {
        this.load();
        return this.restaurant.getMenu();
    }

    public Dish getDish(Long dishId) {
        this.load();
        return this.restaurant.getMenu()
                .stream()
                .filter(x -> x.getId().equals(dishId))
                .findAny()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Dish with ID " + dishId + " not found."));
    }

    public void deleteDish(Dish dish) {
        this.load();

        this.restaurant.getMenu().remove(dish);
        this.save();
    }

    public Optional<Dish> findDishById(Long dishId) {
        this.load();
        Optional<Dish> dish = Optional.empty();
        try {
            dish = Optional.of(this.getDish(dishId));
        } catch (ResourceNotFoundException ignored) {
        }
        return dish;
    }

    public void put(Long id, Table table) {
        this.load();
        this.restaurant.getHall().put(id, table);
        this.save();
    }

    public void closeAllOrders(Long id) {
        this.load();
        this.restaurant.getHall().closeAllOrders(id);
        this.save();
    }
}
