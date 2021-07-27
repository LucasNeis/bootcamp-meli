package com.meli.storeapi.services;

import com.meli.storeapi.dtos.CustomerDTO;
import com.meli.storeapi.entities.Customer;
import com.meli.storeapi.entities.Order;
import com.meli.storeapi.exceptions.ResourceNotFoundException;
import com.meli.storeapi.forms.CustomerForm;
import com.meli.storeapi.forms.OrderForm;
import com.meli.storeapi.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderService orderService;

    public CustomerService(CustomerRepository customerRepository, OrderService orderService) {
        this.customerRepository = customerRepository;
        this.orderService = orderService;
    }

    public CustomerDTO createCustomer(CustomerForm customerForm) {

        Customer customer = new Customer(customerForm.getName(),
                                         customerForm.getCpf(),
                                         customerForm.getEmail(),
                                         customerForm.getPhone());
        this.customerRepository.addCustomer(customer);
        return CustomerDTO.toDTO(customer);
    }

    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = this.customerRepository.getCustomerById(customerId);
        return CustomerDTO.toDTO(customer);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = this.customerRepository.getAllCustomers();
        return customers.stream().map(CustomerDTO::toDTO).collect(Collectors.toList());
    }

    public CustomerDTO updateCustomer(Long customerId, CustomerForm customerForm) {
        Customer customer = this.customerRepository.getCustomerById(customerId);
        customer.setCpf(customerForm.getCpf());
        customer.setEmail(customerForm.getEmail());
        customer.setPhone(customerForm.getPhone());
        customer.setPhone(customerForm.getPhone());
        this.customerRepository.updateCustomer(customerId, customer);
        return CustomerDTO.toDTO(customer);
    }

    public void deleteCustomerById(Long customerId) {
        this.customerRepository.deleteCustomerById(customerId);
    }

    public CustomerDTO addOrderToCustomer(Long customerId, OrderForm orderForm) {
        Customer customer = this.findCustomerById(customerId).orElseThrow(() ->
                new ResourceNotFoundException("Customer with ID " + customerId + " does not exist."));
        Order order = new Order(orderForm.getProducts());
        customer.addOrder(order);
        this.customerRepository.updateCustomer(customerId, customer);
        return CustomerDTO.toDTO(customer);
    }

    private Optional<Customer> findCustomerById(Long customerId) {
        return this.customerRepository.findCustomerById(customerId);
    }

    public CustomerDTO removeOrderFromCustomer(Long customerId, Long orderId) {
        Customer customer = this.findCustomerById(customerId).orElseThrow(() ->
                new ResourceNotFoundException("Customer with ID " + customerId + " does not exist."));
        Order order = this.orderService.findOrderById(customerId, orderId).orElseThrow(() ->
                new ResourceNotFoundException(("Order with ID " + orderId + " does not exist.")));
        customer.removeOrder(order);
        this.customerRepository.updateCustomer(customerId, customer);
        return CustomerDTO.toDTO(customer);
    }
}
