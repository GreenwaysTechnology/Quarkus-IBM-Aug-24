package com.ibm;

import io.smallrye.mutiny.Multi;

public class MultiStreamProcessing {
    public static void main(String[] args) {
        Multi.createFrom().range(1, 390)
                .filter(data -> data % 2 != 0)
                .select().distinct()
                .select().first(10)
                .subscribe().with(System.out::println);
    }
}
