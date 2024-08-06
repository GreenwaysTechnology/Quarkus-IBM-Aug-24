package com.ibm;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.*;


//@RegisterRestClient
@RegisterRestClient(configKey = "customers-api")
@Path("customers")
public interface CustomerRestClientService {
    //all callee rest api declarations
    //api declaration of callee
    @GET
    Uni<String> findAll();

    @GET
    @Path("{id}")
    String findById(@PathParam("id") Long id);

    @POST
    String create(String payload);

    @PUT
    @Path("{id}")
    String update(@PathParam("id") Long id);

    @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") Long id);

}
