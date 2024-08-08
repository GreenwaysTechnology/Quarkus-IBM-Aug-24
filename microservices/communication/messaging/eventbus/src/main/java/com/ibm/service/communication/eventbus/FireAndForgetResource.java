package com.ibm.service.communication.eventbus;

import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("fireandforgot")
public class FireAndForgetResource {

    @Inject
    EventBus eventBus;

    @POST
    public void process(String payload) {
        eventBus.requestAndForget("sink", payload);
    }
}
