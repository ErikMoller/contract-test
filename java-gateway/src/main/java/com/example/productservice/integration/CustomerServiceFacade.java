package com.example.productservice.integration;

import com.example.productservice.domain.Customer;
import com.example.productservice.domain.CustomerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

@Service
public class CustomerServiceFacade {

    private final RestTemplate restTemplate;

    private static final String URL = "http://localhost:8081/v1/customer/";

    @Autowired
    public CustomerServiceFacade(RestTemplate restTemplate) {
        this.restTemplate = requireNonNull(restTemplate, "restTemplate");
    }

    public Customer get(CustomerId customerId) {
        return restTemplate.getForObject(URL +customerId.getValue(),Customer.class);
    }

    @SuppressWarnings("")
    public Collection<Customer> getAll() {
        return restTemplate.getForObject(URL,Collection.class);
    }

    public void create(Customer customer) {
        restTemplate.postForObject(URL,customer,Void.class);
    }

    public void update(Customer customer) {
        restTemplate.postForObject(URL+customer.getId().getValue(), customer,Void.class);
    }

    public void delete(CustomerId customerId) {
        restTemplate.delete(URL + customerId.getValue());
    }
}
