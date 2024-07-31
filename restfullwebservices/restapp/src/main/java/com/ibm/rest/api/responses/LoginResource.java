package com.ibm.rest.api.responses;

import com.ibm.rest.api.payload.entity.User;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("login")
public class LoginResource {

    //login
    @POST
    public Response login(User user) {
        if (user.getUserName().equals("admin") && user.getPassword().equals("admin")) {
            String jwtToken = "Abc23232323asfafd";
            return Response.status(200).entity("Login success").header("auth-token", jwtToken).build();
        }
        return Response.status(400).entity("Login Failed").build();
    }
}
