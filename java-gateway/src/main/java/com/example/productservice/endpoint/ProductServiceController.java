package com.example.productservice.endpoint;

import com.example.productservice.domain.Product;
import com.example.productservice.domain.ProductId;
import com.example.productservice.integration.ProductServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("productService/v1/product")
@CrossOrigin("*")
public class ProductServiceController {

    private final ProductServiceFacade productServiceFacade;

    @Autowired
    public ProductServiceController(ProductServiceFacade productServiceFacade) {
        this.productServiceFacade = requireNonNull(productServiceFacade, "productServiceFacade");
    }

    // curl localhost:8082/productService/v1/product/<id>
    @GetMapping("/{id}")
    public Product get(@PathVariable("id") int id) {
        return productServiceFacade.get(ProductId.valueOf(id));
    }

    // curl localhost:8082/productService/v1/product
    @GetMapping
    public Collection<Product> getAll() {
        return productServiceFacade.getAll();
    }

    // curl -X POST -d '{"name": "shirt"}' -H "Content-Type: application/json" localhost:8082/productService/v1/product
    @PostMapping
    public void create(@RequestBody Product product) {
        productServiceFacade.create(product);
    }

    //curl -X POST -d '{"name": "shirt2"}' -H "Content-Type: application/json" localhost:8082/productService/v1/product/<id>
    @PostMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Product product) {
        product.setId(ProductId.valueOf(id));
        productServiceFacade.update(product);
    }

    // curl -X DELETE localhost:8082/productService/v1/product/<id>
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        productServiceFacade.delete(ProductId.valueOf(id));
    }
}
