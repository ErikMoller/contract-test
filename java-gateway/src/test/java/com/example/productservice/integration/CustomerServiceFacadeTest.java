package com.example.productservice.integration;

import com.example.productservice.configuration.GatewayProperties;
import com.example.productservice.domain.Customer;
import com.example.productservice.domain.CustomerId;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

@Ignore
public class CustomerServiceFacadeTest {

    private static CustomerServiceFacade customerServiceFacade;

    @BeforeClass
    public static void beforeClass() {
        GatewayProperties properties = new GatewayProperties();
        properties.setProductServiceUrl("http://localhost:8080/v1/product/");
        customerServiceFacade = new CustomerServiceFacade(new RestTemplate(),properties);
    }

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