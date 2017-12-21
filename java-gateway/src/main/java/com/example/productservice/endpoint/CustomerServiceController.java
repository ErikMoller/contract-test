package com.example.productservice.endpoint;

import com.example.productservice.domain.Customer;
import com.example.productservice.domain.CustomerId;
import com.example.productservice.integration.CustomerServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("customerService/v1/customer")
@CrossOrigin("*")
public class CustomerServiceController {

    private final CustomerServiceFacade customerServiceFacade;

    @Autowired
    public CustomerServiceController(CustomerServiceFacade customerServiceFacade) {
        this.customerServiceFacade = requireNonNull(customerServiceFacade, "customerServiceFacade");
    }

    // curl localhost:8082/customerService/v1/customer/<id>
    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") int id) {
        return customerServiceFacade.get(CustomerId.valueOf(id));
    }

    // curl localhost:8082/customerService/v1/customer
    @GetMapping
    public Collection<Customer> getAll() {
        return customerServiceFacade.getAll();
    }

    // curl -X POST -d '{"name": "Erik"}' -H "Content-Type: application/json" localhost:8082/customerService/v1/customer
    @PostMapping
    public void create(@RequestBody Customer customer) {
        customerServiceFacade.create(customer);
    }

    //curl -X POST -d '{"name": "shirt2"}' -H "Content-Type: application/json" localhost:8082/customerService/v1/customer/1
    @PostMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Customer customer) {
        customer.setId(CustomerId.valueOf(id));
        customerServiceFacade.update(customer);
    }

    // curl -X DELETE localhost:8082/customerService/v1/customer/<id>
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        customerServiceFacade.delete(CustomerId.valueOf(id));
    }
}
