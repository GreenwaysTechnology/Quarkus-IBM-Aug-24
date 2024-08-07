package com.ibm.fault.cb;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("cb")
public class CircuitBreakerResource {

    private AtomicLong counter = new AtomicLong();

    @GET
    @CircuitBreaker(requestVolumeThreshold = 4)
    @Fallback(fallbackMethod = "fallback")
    public List<String> getProducts() {
        maybeFail();
        return List.of("Product1", "Product2", "Product");
    }

    public List<String> fallback() {
        return List.of("Fallback Responses");
    }

    private void maybeFail() {
        final Long invocationCounter = counter.getAndIncrement();
        if (invocationCounter % 4 > 1) {
            System.out.println(invocationCounter);
            throw new RuntimeException("Service Got failed");
        }
    }
}
