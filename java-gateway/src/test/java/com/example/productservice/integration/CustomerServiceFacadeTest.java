package com.example.productservice.integration;

import com.example.productservice.domain.Customer;
import com.example.productservice.domain.CustomerId;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class CustomerServiceFacadeTest {

    private final CustomerServiceFacade customerServiceFacade = new CustomerServiceFacade(new RestTemplate());

    @Test
    public void create() {
        Customer customer = new Customer("Erik");
        customerServiceFacade.create(customer);
    }

    @Test
    public void get() {
        Customer customer = customerServiceFacade.get(CustomerId.valueOf(1));
        System.out.println(customer);
    }

    @Test
    public void getAll() {
        System.out.println(customerServiceFacade.getAll());
    }

    @Test
    public void update() {
        CustomerId id = CustomerId.valueOf(1);
        customerServiceFacade.update(new Customer(id, "Himanshu"));
    }

    @Test
    public void delete() {
        customerServiceFacade.delete(CustomerId.valueOf(2));
    }
}