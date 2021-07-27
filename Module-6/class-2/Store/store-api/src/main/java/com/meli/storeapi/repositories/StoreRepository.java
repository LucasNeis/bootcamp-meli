package com.meli.storeapi.repositories;

import com.meli.storeapi.entities.Customer;
import com.meli.storeapi.entities.Store;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRepository {
    private final Store store;

    public StoreRepository() {
        this.store = new Store();
    }

    public Customer getCustomerById(Long customerId) {
        return this.store.getCustomerById(customerId);
    }
}
