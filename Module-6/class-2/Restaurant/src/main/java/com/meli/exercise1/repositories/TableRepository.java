package com.meli.exercise1.repositories;

import com.meli.exercise1.entities.Hall;
import com.meli.exercise1.entities.Table;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class TableRepository {
    private Hall hall;

    public BigDecimal cleanUp(Long tableId) {
        Table table = this.hall.getTable(tableId);
        BigDecimal total = table.getTotal();
        table.clear();
        return total;
    }
}
