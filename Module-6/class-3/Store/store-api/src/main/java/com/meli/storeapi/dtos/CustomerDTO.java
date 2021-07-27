package com.meli.storeapi.dtos;

import com.meli.storeapi.entities.Customer;

public class CustomerDTO {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, String cpf, String email, String phone) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    public static CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(customer.getId(),
                                customer.getName(),
                                customer.getCpf(),
                                customer.getEmail(),
                                customer.getPhone());
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
