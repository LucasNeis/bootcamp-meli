package com.meli.storeapi.controllers;

import com.meli.storeapi.forms.CustomerForm;
import com.meli.storeapi.dtos.CustomerDTO;
import com.meli.storeapi.dtos.OrderDTO;
import com.meli.storeapi.forms.OrderForm;
import com.meli.storeapi.services.CustomerService;
import com.meli.storeapi.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final OrderService orderService;
    private final CustomerService customerService;

    public CustomerController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerForm customerForm) {
        return this.customerService.createCustomer(customerForm);
    }

    @GetMapping("{customerId}")
    public CustomerDTO getCustomer(@PathVariable Long customerId) {
        return this.customerService.getCustomerById(customerId);
    }

    @GetMapping()
    public List<CustomerDTO> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    @GetMapping("{customerId}/orders")
    public List<OrderDTO> getAllCustomerOrders(@PathVariable Long customerId) {
        return this.orderService.getAllCustomerOrders(customerId);
    }

    @PutMapping("{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerForm customerForm) {
        return this.customerService.updateCustomer(customerId, customerForm);
    }

    @PutMapping("{customerId}/order")
    public CustomerDTO addOrderToCustomer(@PathVariable Long customerId, @RequestBody OrderForm orderForm) {
        return this.customerService.addOrderToCustomer(customerId, orderForm);
    }

    @PutMapping("{customerId}/order/{orderId}")
    public CustomerDTO removeOrderFromCustomer(@PathVariable Long customerId, @PathVariable Long orderId) {
        return this.customerService.removeOrderFromCustomer(customerId, orderId);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        this.customerService.deleteCustomerById(customerId);
    }
}
