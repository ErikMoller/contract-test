package com.example.productservice.repository;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

    private final AtomicInteger counter = new AtomicInteger(1);

    public int generate() {
        return counter.getAndIncrement();
    }
}
