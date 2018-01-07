package com.example.productservice;

import com.example.productservice.endpoint.CustomerController;
import com.example.productservice.repository.CustomerRepositoryInMemory;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class MvcTest {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new CustomerController(new CustomerRepositoryInMemory()));
    }
}
