package com.example.productservice.repository;

import com.example.productservice.domain.Customer;
import com.example.productservice.domain.CustomerId;

import java.util.Collection;

public interface CustomerRepository {

    void create(Customer customer);

    void update(Customer customer);

    Customer read(CustomerId customerId);

    Collection<Customer> readAll();

    void delete(CustomerId customerId);


}
