package com.ibm.service.communication.eventbus;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.Message;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("requestreply")
public class EventResource {

    @Inject
    EventBus eventBus;

    @GET
    @Path("{name}")
    public Uni<String> greeting(@PathParam("name") String name) {
        //publish message on given address
        return eventBus.<String>request("greeting", name).onItem().transform(Message::body);
    }
}
