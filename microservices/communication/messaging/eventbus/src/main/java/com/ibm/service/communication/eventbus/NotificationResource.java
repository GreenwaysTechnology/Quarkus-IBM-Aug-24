package com.ibm.service.communication.eventbus;

import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("pubsub")
public class NotificationResource {

    @Inject
    EventBus eventBus;

    @POST
    public void publish(String message) {
        eventBus.publish("notification", message);
    }
}
