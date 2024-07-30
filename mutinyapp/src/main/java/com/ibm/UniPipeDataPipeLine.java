package com.ibm;

import io.smallrye.mutiny.Uni;

import java.time.Duration;

public class UniPipeDataPipeLine {
    public static void main(String[] args) {
        Uni.createFrom().item("hello")
                .onItem().transform(data->data.toUpperCase())
                .onItem().delayIt().by(Duration.ofMillis(10000))
                .subscribe().with(System.out::println);
    }
}
