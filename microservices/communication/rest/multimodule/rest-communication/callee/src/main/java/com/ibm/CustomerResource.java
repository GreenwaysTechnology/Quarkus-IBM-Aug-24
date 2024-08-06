package com.ibm;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;

@Path("customers")
public class CustomerResource {
    //curd operations
    @GET
    public Uni<String> findAll() {
        return Uni.createFrom().item("findAll Reactive");
    }

    @Path("{id}")
    @GET
    public String findById(@PathParam("id") Long id) {
        return "Find By Id " + id;
    }

    @POST
    public String create(String payload) {
        return "Saved  " + payload;
    }

    @PUT
    @Path("{id}")
    public String update(@PathParam("id") Long id) {
        return "Update By id " + id;
    }

    @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") Long id) {
        return "Remove By id " + id;
    }

}
