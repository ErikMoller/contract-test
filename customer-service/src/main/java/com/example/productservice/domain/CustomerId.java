package com.example.productservice.domain;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class CustomerId {

    private int value;

    public CustomerId() {
    }

    public CustomerId(int value) {
        this.value = requireNonNull(value, "value");
    }

    public static CustomerId valueOf(int value) {
        return new CustomerId(value);
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
        CustomerId customerId = (CustomerId) o;
        return value == customerId.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "CustomerId{" +
                "value=" + value +
                '}';
    }
}
