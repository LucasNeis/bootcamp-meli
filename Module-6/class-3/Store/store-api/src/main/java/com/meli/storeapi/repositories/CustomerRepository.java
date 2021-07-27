package com.meli.storeapi.repositories;

import com.meli.storeapi.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {
    private final StoreRepository storeRepository;

    public CustomerRepository(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void addCustomer(Customer customer) {
        this.storeRepository.addCustomer(customer);
    }

    public Customer getCustomerById(Long customerId) {
        return this.storeRepository.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return this.storeRepository.getAllCustomers();
    }

    public void updateCustomer(Long customerId, Customer customer) {
        this.storeRepository.updateCustomer(customerId, customer);
    }

    public void deleteCustomerById(Long customerId) {
        this.storeRepository.deleteCustomerById(customerId);
    }

    public Optional<Customer> findCustomerById(Long customerId) {
        return this.storeRepository.findCustomerById(customerId);
    }
}
