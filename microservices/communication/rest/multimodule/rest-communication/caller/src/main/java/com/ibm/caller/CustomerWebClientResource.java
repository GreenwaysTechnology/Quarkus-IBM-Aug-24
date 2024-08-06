package com.ibm.caller;

import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.client.HttpResponse;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import io.vertx.mutiny.ext.web.client.WebClient;

@Path("api/webclient")
public class CustomerWebClientResource {

    @Inject
    Vertx vertx;
    WebClient webClient;

    public void init(@Observes StartupEvent startupEvent) {
        //create instance of web client
        webClient = WebClient.create(vertx, new WebClientOptions().setDefaultHost("localhost").setDefaultPort(8081));
    }

    //write api to call callee
    @GET
    public Uni<String> findAll() {
        return webClient.get("/customers").send().onItem().transform(HttpResponse::bodyAsString);
    }

}
