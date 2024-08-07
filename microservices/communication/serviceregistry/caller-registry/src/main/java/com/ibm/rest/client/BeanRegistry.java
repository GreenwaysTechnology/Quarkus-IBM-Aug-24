package com.ibm.rest.client;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.Vertx;
import io.vertx.ext.consul.ConsulClient;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.ext.consul.ServiceOptions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class BeanRegistry {

    @ConfigProperty(name = "consul.host")
    String host;

    @ConfigProperty(name = "consul.port")
    int port;

    //service running port
    @ConfigProperty(name = "hello-service-port", defaultValue = "8081")
    int helloPort;
    @ConfigProperty(name="hello-host",defaultValue = "localhost")
    String helloHost;

    public void init(@Observes StartupEvent startupEvent, Vertx vertx) {
        ConsulClient client = ConsulClient.create(vertx,
                new ConsulClientOptions().setPort(port).setHost(host)
        );
//        //service Registeration
        client.registerService(new ServiceOptions()
                .setId("hello")
                .setName("hello-service")
                .setAddress(helloHost)
                .setPort(helloPort)
        );
        //with load blancing
        //Register service with Consul Server
        ServiceOptions serviceOptions1 = new ServiceOptions()
                .setId("hello1")
                .setName("hello-service")
                .setAddress("localhost")
                .setPort(helloPort);

        ServiceOptions serviceOptions2 = new ServiceOptions()
                .setId("hello2")
                .setName("hello-service")
                .setAddress("localhost")
                .setPort(helloPort);

        client.registerService(serviceOptions1);
        client.registerService(serviceOptions2);
    }
}
