package com.ibm;

import io.smallrye.mutiny.Uni;

public class ErrorEvent {
    public static void main(String[] args) {
        Uni.createFrom().failure(new RuntimeException("oops")).subscribe().with(data->{},err->{
            System.out.println(err);
        });
    }
}
