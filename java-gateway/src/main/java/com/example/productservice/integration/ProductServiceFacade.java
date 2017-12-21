package com.example.productservice.integration;

import com.example.productservice.domain.Product;
import com.example.productservice.domain.ProductId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

@Service
public class ProductServiceFacade {

    private final RestTemplate restTemplate;

    private static final String URL = "http://localhost:8080/v1/product/";

    @Autowired
    public ProductServiceFacade(RestTemplate restTemplate) {
        this.restTemplate = requireNonNull(restTemplate, "restTemplate");
    }

    public Product get(ProductId productId) {
        return restTemplate.getForObject(URL +productId.getValue(),Product.class);
    }

    public Collection<Product> getAll() {
        return restTemplate.getForObject(URL,Collection.class);
    }

    public void create(Product product) {
        restTemplate.postForObject(URL,product,Void.class);
    }


    public void update(Product product) {
        restTemplate.postForObject(URL+product.getId().getValue(), product,Void.class);
    }

    public void delete(ProductId productId) {
        restTemplate.delete(URL + productId.getValue());
    }
}
