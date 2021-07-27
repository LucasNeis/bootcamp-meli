package com.meli.exercise1.services;

import com.meli.exercise1.DTOs.CashierDTO;
import com.meli.exercise1.DTOs.DishDTO;
import com.meli.exercise1.Forms.DishForm;
import com.meli.exercise1.entities.Cashier;
import com.meli.exercise1.entities.Dish;
import com.meli.exercise1.entities.Order;
import com.meli.exercise1.entities.Table;
import com.meli.exercise1.exceptions.ImpossibleToAccessException;
import com.meli.exercise1.repositories.CashierRepository;
import com.meli.exercise1.repositories.RestaurantRepository;
import com.meli.exercise1.repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    private final CashierRepository cashierRepository;
    private final TableRepository tableRepository;
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(CashierRepository cashierRepository, TableRepository tableRepository, RestaurantRepository restaurantRepository) {
        this.cashierRepository = cashierRepository;
        this.tableRepository = tableRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public CashierDTO getCashier() throws ImpossibleToAccessException {
        Cashier cashier = this.cashierRepository.getCashier();
        return CashierDTO.toDTO(cashier);
    }

    public void addMoney(BigDecimal payment) throws ImpossibleToAccessException {
        this.cashierRepository.addMoney(payment);
    }

    public BigDecimal payBill(Long tableId) {
        Table table = this.tableRepository.getTableById(tableId);
        List<Order> orders = table.getOrders();
        Optional<BigDecimal> total = orders.stream()
                .filter(Order::isActive)
                .map(Order::getTotal)
                .reduce(BigDecimal::add);
        if(total.isEmpty()) {
            throw new RuntimeException("No order to be closed.");
        };
        this.cashierRepository.addMoney(total.get());
        this.tableRepository.closeAllOrders(tableId);
        this.tableRepository.save();
        return total.get();
    }

    public DishDTO addDish(DishForm form) {
        com.meli.exercise1.entities.Dish dish = new com.meli.exercise1.entities.Dish(form.getDescription(), form.getQuantity(), form.getPrice());
        return DishDTO.toDTO(this.restaurantRepository.addDish(dish));
    }

    public List<DishDTO> getAllDishes() {
        List<com.meli.exercise1.entities.Dish> dishes = this.restaurantRepository.getAllDishes();
        return dishes.stream()
                .map(x->new DishDTO(
                        x.getId(),
                        x.getPrice(),
                        x.getDescription(),
                        x.getQuantity()))
                .collect(Collectors.toList());
    }

    public DishDTO getDish(Long dishId) {
        return DishDTO.toDTO(this.restaurantRepository.getDish(dishId));
    }

    public DishDTO updateDish(Long dishId, DishForm dishForm) {
        com.meli.exercise1.entities.Dish dish = this.restaurantRepository.getDish(dishId);
        dish.setDescription(dishForm.getDescription());
        dishForm.setPrice(dishForm.getPrice());
        dish.setQuantity(dishForm.getQuantity());
        this.restaurantRepository.save();
        return DishDTO.toDTO(dish);
    }

    public void deleteDish(Long dishId) {
        com.meli.exercise1.entities.Dish dish = this.restaurantRepository.getDish(dishId);
        this.restaurantRepository.deleteDish(dish);
    }

    public Optional<Dish> FindDishById(Long dishId) {
        return this.restaurantRepository.findDishById(dishId);
    }
}
