package com.example.productservice.domain;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class ProductId {

    private int value;

    public ProductId() {
    }

    public ProductId(int value) {
        this.value = requireNonNull(value, "value");
    }

    public static ProductId valueOf(int value) {
        return new ProductId(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductId productId = (ProductId) o;
        return value == productId.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ProductId{" +
                "value=" + value +
                '}';
    }
}
