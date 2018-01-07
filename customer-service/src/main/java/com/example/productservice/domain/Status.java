package com.example.productservice.domain;

import static java.util.Objects.requireNonNull;

public class Status {

    private String status;

    public Status(String status) {
        this.status = requireNonNull(status,"status");
    }

    public static Status valueOf(String status) {
        return new Status(status);
    }

    public Status() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
