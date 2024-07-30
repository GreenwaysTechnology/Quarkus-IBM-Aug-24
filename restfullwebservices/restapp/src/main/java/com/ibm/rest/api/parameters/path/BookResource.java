package com.ibm.rest.api.parameters.path;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("books")
public class BookResource {

    //findBy Book
    @GET
    @Path("{Id}")
    public String findById(@PathParam("Id") Long id){
        return "Book By Id " + id;
    }
}
