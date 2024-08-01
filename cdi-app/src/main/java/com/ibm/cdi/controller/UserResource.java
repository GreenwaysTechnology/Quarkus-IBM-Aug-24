package com.ibm.cdi.controller;

import com.ibm.cdi.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("users")
public class UserResource {
    //  UserService userService = new UserService();
    @Inject
    UserService userService;

//    private UserService userService;

//    @Inject
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }


//    @Inject
//    public UserResource(UserService userService) {
//        this.userService = userService;
//    }

    @GET
    public List<String> users() {
        return userService.users();
    }
}
