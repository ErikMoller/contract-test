package com.example.productservice.integration;

import com.example.productservice.configuration.GatewayProperties;
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

    private final String productServiceUrl;

    @Autowired
    public ProductServiceFacade(RestTemplate restTemplate, GatewayProperties properties) {
        this.restTemplate = requireNonNull(restTemplate, "restTemplate");
        requireNonNull(properties, "properties");
        this.productServiceUrl = properties.getProductServiceUrl();
    }

    public Product get(ProductId productId) {
        return restTemplate.getForObject(productServiceUrl +productId.getValue(),Product.class);
    }

    public Collection<Product> getAll() {
        return restTemplate.getForObject(productServiceUrl,Collection.class);
    }

    public void create(Product product) {
        restTemplate.postForObject(productServiceUrl,product,Void.class);
    }


    public void update(Product product) {
        restTemplate.postForObject(productServiceUrl+product.getId().getValue(), product,Void.class);
    }

    public void delete(ProductId productId) {
        restTemplate.delete(productServiceUrl + productId.getValue());
    }
}
