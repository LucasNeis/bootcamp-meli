package com.meli.exercise1.Forms;

import java.util.ArrayList;
import java.util.List;

public class OrderForm {
    private List<Long> dishes = new ArrayList<>();

    public OrderForm() {
    }

    public OrderForm(List<Long> dishes) {
        this.dishes = dishes;
    }

    public List<Long> getDishes() {
        return dishes;
    }

    public void setDishes(List<Long> dishes) {
        this.dishes = dishes;
    }
}
