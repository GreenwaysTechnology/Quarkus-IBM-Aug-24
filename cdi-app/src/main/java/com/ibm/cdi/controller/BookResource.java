package com.ibm.cdi.controller;

import com.ibm.cdi.services.NumberGenerator;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("books")
public class BookResource {
    //inject
    @Inject
    NumberGenerator numberGenerator;

    @GET
    public String getBOOKISBN() {
        return numberGenerator.generateISBNGenerator();
    }
}
