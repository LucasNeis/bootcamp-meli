package com.meli.exercise1.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private Cashier cashier;
    private Hall hall;
    List<Dish> menu = new ArrayList<>();

    public Restaurant() {
        this.cashier = new Cashier();
        this.hall = new Hall();
    }

    public Restaurant(Cashier cashier, Hall hall) {
        this.cashier = cashier;
        this.hall = hall;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public Hall getHall() {
        return hall;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }
}
