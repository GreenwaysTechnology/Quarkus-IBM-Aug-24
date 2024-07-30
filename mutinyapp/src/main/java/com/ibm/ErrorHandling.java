package com.ibm;

import io.smallrye.mutiny.Uni;

public class ErrorHandling {
    public static void main(String[] args) {
        Uni.createFrom().failure(new RuntimeException("oops")).subscribe().with(data -> {
        }, err -> {
            System.out.println(err);
        });

        Uni.createFrom().failure(new RuntimeException("oops"))
                .onFailure().recoverWithItem("fallback")
                .subscribe().with(data -> {
                    System.out.println(data);
                });
    }
}
