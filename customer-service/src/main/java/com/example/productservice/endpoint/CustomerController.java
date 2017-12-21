package com.example.productservice.endpoint;

import com.example.productservice.domain.Customer;
import com.example.productservice.domain.CustomerId;
import com.example.productservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("v1/customer")
@CrossOrigin("*")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = requireNonNull(customerRepository, "customerRepository");
    }

    // curl localhost:8081/v1/customer/<id>
    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") int id) {
        return customerRepository.read(CustomerId.valueOf(id));
    }

    // curl localhost:8081/v1/customer
    @GetMapping
    public Collection<Customer> getAll() {
        return customerRepository.readAll();
    }

    // curl -X POST -d '{"name": "Erik"}' -H "Content-Type: application/json" localhost:8081/v1/customer
    @PostMapping
    public void create(@RequestBody Customer customer) {
        customerRepository.create(customer);
    }

    //curl -X POST -d '{"name": "shirt2"}' -H "Content-Type: application/json" localhost:8081/v1/customer/1
    @PostMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Customer customer) {
        customer.setId(CustomerId.valueOf(id));
        customerRepository.update(customer);
    }

    // curl -X DELETE localhost:8080/v1/product/<id>
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        customerRepository.delete(CustomerId.valueOf(id));
    }
}
