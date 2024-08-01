package com.ibm.cdi.services;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ISBNGeneratorImpl implements NumberGenerator {
    @Override
    public String generateISBNGenerator() {
        return "2232323232323";
    }
}
