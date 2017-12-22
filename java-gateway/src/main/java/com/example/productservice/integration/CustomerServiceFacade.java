package com.example.productservice.integration;

import com.example.productservice.configuration.GatewayProperties;
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

    private final String customerServiceUrl;

    @Autowired
    public CustomerServiceFacade(RestTemplate restTemplate, GatewayProperties properties) {
        this.restTemplate = requireNonNull(restTemplate, "restTemplate");
        requireNonNull(properties, "properties");
        this.customerServiceUrl = properties.getCustomerServiceUrl();
    }

    public Customer get(CustomerId customerId) {
        return restTemplate.getForObject(customerServiceUrl +customerId.getValue(),Customer.class);
    }

    @SuppressWarnings("")
    public Collection<Customer> getAll() {
        return restTemplate.getForObject(customerServiceUrl,Collection.class);
    }

    public void create(Customer customer) {
        restTemplate.postForObject(customerServiceUrl,customer,Void.class);
    }

    public void update(Customer customer) {
        restTemplate.postForObject(customerServiceUrl+customer.getId().getValue(), customer,Void.class);
    }

    public void delete(CustomerId customerId) {
        restTemplate.delete(customerServiceUrl + customerId.getValue());
    }
}
