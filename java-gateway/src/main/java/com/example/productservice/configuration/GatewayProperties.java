package com.example.productservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="gateway")
public class GatewayProperties {

    private String productServiceUrl;
    private String customerServiceUrl;

    public String getProductServiceUrl() {
        return productServiceUrl;
    }

    public void setProductServiceUrl(String productServiceUrl) {
        this.productServiceUrl = productServiceUrl;
    }

    public String getCustomerServiceUrl() {
        return customerServiceUrl;
    }

    public void setCustomerServiceUrl(String customerServiceUrl) {
        this.customerServiceUrl = customerServiceUrl;
    }
}
