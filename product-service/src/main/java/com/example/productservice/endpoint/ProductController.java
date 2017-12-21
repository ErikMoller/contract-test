package com.example.productservice.endpoint;

import com.example.productservice.domain.Product;
import com.example.productservice.domain.ProductId;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("v1/product")
@CrossOrigin("*")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = requireNonNull(productRepository, "productRepository");
    }

    // curl localhost:8080/v1/product/<id>
    @GetMapping("/{id}")
    public Product get(@PathVariable("id") int id) {
        return productRepository.read(ProductId.valueOf(id));
    }

    // curl localhost:8080/v1/product
    @GetMapping
    public Collection<Product> getAll() {
        return productRepository.readAll();
    }

    // curl -X POST -d '{"name": "shirt"}' -H "Content-Type: application/json" localhost:8080/v1/product
    @PostMapping
    public void create(@RequestBody Product product) {
        productRepository.create(product);
    }

    //curl -X POST -d '{"name": "shirt2"}' -H "Content-Type: application/json" localhost:8080/v1/product/1
    @PostMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Product product) {
        product.setId(ProductId.valueOf(id));
        productRepository.update(product);
    }

    // curl -X DELETE localhost:8080/v1/product/<id>
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        productRepository.delete(ProductId.valueOf(id));
    }
}
