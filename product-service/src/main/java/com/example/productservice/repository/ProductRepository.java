package com.example.productservice.repository;

import com.example.productservice.domain.Product;
import com.example.productservice.domain.ProductId;

import java.util.Collection;

public interface ProductRepository {

    void create(Product product);

    void update(Product product);

    Product read(ProductId productId);

    Collection<Product> readAll();

    void delete(ProductId productId);


}
