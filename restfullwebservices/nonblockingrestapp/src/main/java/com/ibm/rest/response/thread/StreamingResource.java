package com.ibm.rest.response.thread;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.Duration;
import java.util.List;

@Path("stream")
public class StreamingResource {

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Long> stream() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1));
    }

    @GET
    @Path("list")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Integer> list() {

        //return Multi.createFrom().iterable(List.of(1, 2, 3, 4, 5, 6));
        return Multi.createFrom()
                .iterable(List.of(1, 2, 3, 4, 5, 6, 7, 90))
                .onItem().call(i -> {
                    Duration delay = Duration.ofSeconds(1);
                    return Uni.createFrom().nullItem().onItem().delayIt().by(delay);
                });
    }

    @GET
    @Path("teacher")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Teacher> teacherList() {
        List<Teacher> teacherList = List.of(
                new Teacher(1l, "Subramanian", "Quarkus"),
                new Teacher(2l, "Murugan", "Quarkus"),
                new Teacher(3l, "Karthik", "Spring Framework")
        );
        return Multi.createFrom()
                .iterable(teacherList)
                .onItem().call(i -> {
                    Duration delay = Duration.ofSeconds(1);
                    return Uni.createFrom().nullItem().onItem().delayIt().by(delay);
                });
    }
}
