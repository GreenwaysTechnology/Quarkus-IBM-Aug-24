package com.ibm.fault.retries;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Path("retry")
public class RetryResource {

    private AtomicLong counter = new AtomicLong();
    private float failureRatio = 0.5f;

    @GET
    @Retry(maxRetries = 3, retryOn = RuntimeException.class)
    @Fallback(fallbackMethod = "fallbackProducts")
    public List<String> getProducts() {
        final Long invocationNumber = counter.getAndIncrement();
        mayFail(String.format("Retry Resource#getProducts invcation %d failed", invocationNumber));
        return List.of("Product1", "Product2");
    }

    public void mayFail(String failureMessage) {
        if (new Random().nextFloat() < failureRatio) {
            throw new RuntimeException("Resource failed");
        }
    }
    public List<String> fallbackProducts() {
        return List.of("Fallback Products");
    }
}
