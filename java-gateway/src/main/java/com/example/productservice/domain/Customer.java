package com.example.productservice.domain;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Customer {

    private CustomerId id;
    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = requireNonNull(name, "name");
    }

    public Customer(CustomerId id, String name) {
        this.id = requireNonNull(id, "id");
        this.name = requireNonNull(name, "name");
    }

    public CustomerId getId() {
        return id;
    }

    public void setId(CustomerId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
