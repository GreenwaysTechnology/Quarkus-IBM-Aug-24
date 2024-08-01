package com.ibm.cdi.services;

import io.quarkus.runtime.Shutdown;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.List;

@ApplicationScoped
public class UserService {

    List<String> userList;

    @Startup
    public void init() {
        userList = List.of("Subramanian", "Murugan", "Ram");
    }

    public void start(@Observes StartupEvent event) {
        System.out.println("event");
    }

    @Shutdown
    public void destroy() {
        System.out.println("cleanup");
    }

    public List<String> users() {
        return userList;
    }
}
