package com.ibm.rest.api.parameters.query;


import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("countries")
public class Country {

    @GET
    public String getCountryByState(@QueryParam("state") @DefaultValue("TN") String state){
        return  "State " + state;
    }
}
