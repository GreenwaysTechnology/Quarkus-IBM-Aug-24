package com.ibm.cdi.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("sql")
public class SQLRepositoryImpl implements Repository{
    @Override
    public String findAll() {
        return "SQL";
    }
}
