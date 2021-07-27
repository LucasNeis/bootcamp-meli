package com.meli.exercise1.repositories;

import com.meli.exercise1.entities.Dish;
import com.meli.exercise1.entities.Table;
import com.meli.exercise1.exceptions.ImpossibleToAccessException;
import com.meli.exercise1.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TableRepository {

    private final RestaurantRepository restaurantRepository;

    public TableRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Table getTableById(Long id) {
        return this.restaurantRepository.getTableById(id);
    }

    public Optional<Table> findTableById(Long id) {
        Optional<Table> found;
        try {
            found = Optional.of(this.restaurantRepository.getTableById(id));
        } catch (ImpossibleToAccessException ex) {
            found = Optional.empty();
        }
        return found;
    }

    public Table addTable(Table table) {
        return this.restaurantRepository.addTable(table);
    }

    public void deleteTable(Table table) {
        this.restaurantRepository.deleteTable(table);
    }

    public void deleteTableById(Long id) throws ImpossibleToAccessException, ResourceNotFoundException {
        Optional<Table> table = this.findTableById(id);
        if (table.isEmpty()) {
            throw new ResourceNotFoundException("Table with ID " + id + " does not exist.");
        }
        this.deleteTable(table.get());
    }

    public void createTable(Table table) {
        this.restaurantRepository.addTable(table);
    }

    public void save() {
        this.restaurantRepository.save();
    }

    public void save(Table table) {
        System.out.println("--------------------------------------------------------------------------------");
        table.getOrders().forEach(x -> x.getDishes().stream().map(Dish::getDescription).forEach(System.out::println));
        this.restaurantRepository.put(table.getId(), table);
    }

    public List<Table> getAllTables() {
        return this.restaurantRepository.getAllTables();
    }

    public void closeAllOrders(Long tableId) {
        this.restaurantRepository.closeAllOrders(tableId);
    }
}
