package com.example.productservice.repository;

import com.example.productservice.domain.Customer;
import com.example.productservice.domain.CustomerId;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepositoryInMemory implements CustomerRepository {

    private final Map<CustomerId, Customer> products = new HashMap<>();
    private final IdGenerator idGenerator = new IdGenerator();

    @Override
    public void create(Customer customer) {
        CustomerId id = CustomerId.valueOf(idGenerator.generate());
        customer.setId(id);
        products.put(id, customer);
    }

    @Override
    public void update(Customer customer) {
        products.put(customer.getId(), customer);
    }

    @Override
    public Customer read(CustomerId customerId) {
        return products.get(customerId);
    }

    @Override
    public Collection<Customer> readAll() {
        return products.values();
    }

    @Override
    public void delete(CustomerId customerId) {
        products.remove(customerId);
    }
}
