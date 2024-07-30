package com.ibm;

import io.smallrye.mutiny.Uni;

public class HelloMutiny {
    public static void main(String[] args) {
        //create Uni object and emit Hello data(stream) - as soon as data is emitted, the subscriber
        //who has attached will receive data(event)
        Uni.createFrom().item("Hello").subscribe().with(data->{
            System.out.println(data);
        });
    }
}
