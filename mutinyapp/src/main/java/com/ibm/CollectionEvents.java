package com.ibm;

import io.smallrye.mutiny.Multi;

import java.util.List;

public class CollectionEvents {
    public static void main(String[] args) {
        List mylist = List.of(1, 2, 4, 56, 78);
        Multi.createFrom().iterable(mylist).subscribe().with(System.out::println);
    }
}
