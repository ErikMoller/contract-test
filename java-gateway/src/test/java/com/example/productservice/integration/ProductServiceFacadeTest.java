package com.example.productservice.integration;

import com.example.productservice.domain.Product;
import com.example.productservice.domain.ProductId;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class ProductServiceFacadeTest {

    private final ProductServiceFacade productServiceFacade = new ProductServiceFacade(new RestTemplate());

    @Test
    public void create() {
        Product product= new Product("Shirt");
        productServiceFacade.create(product);
    }

    @Test
    public void get() {
        Product product = productServiceFacade.get(ProductId.valueOf((1)));
        System.out.println(product);
    }

    @Test
    public void getAll() {
        System.out.println(productServiceFacade.getAll());
    }

    @Test
    public void update() {
        ProductId id = ProductId.valueOf(1);
        productServiceFacade.update(new Product(id, "Shoe"));
    }

    @Test
    public void delete() {
        productServiceFacade.delete(ProductId.valueOf(1));
    }

}