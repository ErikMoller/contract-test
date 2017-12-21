package com.example.productservice.repository;

import com.example.productservice.domain.Product;
import com.example.productservice.domain.ProductId;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryInMemory implements ProductRepository {

    private final Map<ProductId, Product> products = new HashMap<>();
    private final IdGenerator idGenerator = new IdGenerator();

    @Override
    public void create(Product product) {
        ProductId id = ProductId.valueOf(idGenerator.generate());
        product.setId(id);
        products.put(id,product);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product read(ProductId productId) {
        return products.get(productId);
    }

    @Override
    public Collection<Product> readAll() {
        return products.values();
    }

    @Override
    public void delete(ProductId productId) {
        products.remove(productId);
    }
}
