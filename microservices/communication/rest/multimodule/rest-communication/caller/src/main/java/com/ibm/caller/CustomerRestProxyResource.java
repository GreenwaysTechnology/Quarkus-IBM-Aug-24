package com.ibm.caller;

import com.ibm.CustomerRestClientService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("api/customers")
public class CustomerRestProxyResource {

    @Inject
    @RestClient
    CustomerRestClientService client;

    //our api
    @GET
    public Uni<String> findAll() {
        return client.findAll();
    }


    @GET
    @Path("{id}")
    public String findById(@PathParam("id") Long id) {
        return client.findById(id);
    }

    @POST
    public String create(String payload) {
        return client.create(payload);
    }

    @PUT
    @Path("{id}")
    public String update(@PathParam("id") Long id) {
        return client.update(id);
    }

    @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") Long id) {
        return client.remove(id);
    }
}
