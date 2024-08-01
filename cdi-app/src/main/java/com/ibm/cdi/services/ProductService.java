package com.ibm.cdi.services;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProductService {

    public Uni<List<String>> findAll() {
        return Uni.createFrom().item(List.of("Product1", "Product2"));
    }
}
