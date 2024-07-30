package com.ibm;

import io.smallrye.mutiny.Uni;

class Publisher {
    public static Uni<String> publish() {
        return Uni.createFrom().item("Hello");
    }
}

public class PublisherAndSubscriber {
    public static void main(String[] args) {
     Publisher.publish().subscribe().with(System.out::println);
    }
}
