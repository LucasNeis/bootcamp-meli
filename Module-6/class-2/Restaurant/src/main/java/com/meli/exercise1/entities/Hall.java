package com.meli.exercise1.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Hall {
    private List<Table> tables = new ArrayList<>();


    public Hall(Integer tableCount) {
        for (int i = 0; i < tableCount; i++) {
            this.tables.add(new Table());            
        }
    }


    public List<Table> getTables() {
        return this.tables;
    }

    public Table getTable(Long tableId) {
        return this.tables.stream()
                          .filter(x -> x.getId() == tableId)
                          .findFirst()
                          .get();
    }

    public void addOrderTo(Long tableId, Order order) {
        Table table = this.getTable(tableId);
        table.addOrder(order);
    }

    public void cleanTable(Long tableId) {
        Table table = this.getTable(tableId);
        table.clear();
    }

    public BigDecimal getTableTotal(Long tableId) {
        return this.getTable(tableId).getTotal();
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
    
}
