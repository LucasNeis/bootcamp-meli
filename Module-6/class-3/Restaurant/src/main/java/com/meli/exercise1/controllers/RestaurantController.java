package com.meli.exercise1.controllers;

import com.meli.exercise1.DTOs.CashierDTO;
import com.meli.exercise1.DTOs.DishDTO;
import com.meli.exercise1.Forms.DishForm;
import com.meli.exercise1.services.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService cashier) {
        this.restaurantService = cashier;
    }

    @PostMapping("dishes")
    public DishDTO createDish(@RequestBody DishForm dish) {
        return this.restaurantService.addDish(dish);
    }

    @GetMapping("dishes")
    public List<DishDTO> getAllDishes() {
        return this.restaurantService.getAllDishes();
    }

    @GetMapping("dishes/{dishId}")
    public DishDTO getDish(@PathVariable Long dishId) {
        return this.restaurantService.getDish(dishId);
    }

    @GetMapping("/cashier")
    public CashierDTO getRestaurantService() {
        return this.restaurantService.getCashier();
    }

    @PutMapping("dishes/{dishId}")
    public DishDTO updateDish(@PathVariable Long dishId, @RequestBody DishForm dish) {
        return this.restaurantService.updateDish(dishId, dish);
    }

    @PutMapping("{tableId}")
    public BigDecimal payBill(@PathVariable Long tableId) {
        return this.restaurantService.payBill(tableId);
    }

    @DeleteMapping("dishes/{dishId}")
    public void updateDish(@PathVariable Long dishId) {
        this.restaurantService.deleteDish(dishId);
    }

}
