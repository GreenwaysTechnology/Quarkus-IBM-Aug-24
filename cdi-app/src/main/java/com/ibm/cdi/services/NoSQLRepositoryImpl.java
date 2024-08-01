package com.ibm.cdi.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("nosql")
public class NoSQLRepositoryImpl implements Repository {
    @Override
    public String findAll() {
        return "NOSQL";
    }
}
