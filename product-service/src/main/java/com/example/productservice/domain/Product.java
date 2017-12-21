package com.example.productservice.domain;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Product {

    private ProductId id;
    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = requireNonNull(name, "name");
    }

    public Product(ProductId id, String name) {
        this.id = requireNonNull(id, "id");
        this.name = requireNonNull(name, "name");
    }

    public ProductId getId() {
        return id;
    }

    public void setId(ProductId id) {
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
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
