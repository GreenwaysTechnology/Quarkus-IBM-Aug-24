package com.ibm.fault.timeout;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TimeoutService {

    public List<String> getProducts() throws InterruptedException {
        //simulate delay
        Thread.sleep(6000);
        return List.of("Product1", "Product2");
    }
}
