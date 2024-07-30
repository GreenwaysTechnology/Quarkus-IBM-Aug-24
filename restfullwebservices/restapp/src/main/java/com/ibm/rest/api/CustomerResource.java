package com.ibm.rest.api;

import jakarta.ws.rs.*;

@Path("customers")
public class CustomerResource {
    //api
    @GET
    public String findAll() {
        return "Find all";
    }
    @GET
    @Path("comments")
    public String getComments(){
        return  "Comments";
    }
    @POST
    public String save(){
        return  "Save";
    }
    @PUT
    public String update(){
        return  "update";
    }
    @DELETE
    public String remove(){
        return  "Remove";
    }
}
