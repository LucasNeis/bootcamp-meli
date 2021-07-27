package com.meli.exercise1.entities;

import java.math.BigDecimal;
import java.util.*;

public class Hall {
    //    private List<Table> tables = new ArrayList<>();
    private Map<Long, Table> tables = new HashMap<>();

    public Hall() {
    }

    public Hall(Map<Long, Table> tables) {
        this.tables = tables;
    }

    public Hall(Integer tableCount) {
        for (int i = 0; i < tableCount; i++) {
            Table table = new Table();
            this.tables.put(table.getId(), table);
        }
    }

    public Map<Long, Table> getTables() {
        return this.tables;
    }

    public Table getTable(Long tableId) {
        return this.tables.get(tableId);
    }

    public void addOrderTo(Long tableId, Order order) {
        Table table = this.getTable(tableId);
        table.addOrder(order);
    }

    public void setTables(Map<Long, Table> tables) {
        this.tables = tables;
    }

    public void cleanTable(Long tableId) {
        Table table = this.getTable(tableId);
        table.clear();
    }

    public BigDecimal getTableTotal(Long tableId) {
        return this.getTable(tableId).getTotal();
    }

    public void addTable(Table table) {
        this.tables.put(table.getId(), table);
    }

    public Table getTableById(Long id) {
        return this.tables.get(id);
    }

    public boolean tableExists(Long id) {
        return this.tables.containsKey(id);
    }

    public void deleteTable(Table table) {
        this.tables.remove(table.getId());
    }

    public Order getOrderById(Long id) {
        Order found = null;
        long index = 0L,
             limit = this.getGreatestTableId();
        while (Objects.isNull(found) && index < limit) {
            if (this.tables.containsKey(index)) {
                Optional<Order> first = this.tables.get(index)
                        .getOrders()
                        .stream()
                        .filter(x -> x.getId().equals(id))
                        .findFirst();
                if (first.isPresent()) {
                    found = first.get();
                }
            }
            index++;
        }
        return found;
    }

    private long getGreatestTableId() {
        Optional<Table> max = this.tables
                .values()
                .stream()
                .max((x, y) -> x.getId() > y.getId() ? 1 : -1);
        if (max.isPresent()) {
            return max.get().getId();
        }
        return -1L;
    }

    public boolean doesAnyTableHaveOrders() {
        return this.tables.values().stream().anyMatch(Table::hasOrder);
    }

    public void put(Long id, Table table) {
        this.tables.put(id, table);
    }

    public void closeAllOrders(Long id) {
        this.tables.get(id).closeAllOrders();
    }
}
