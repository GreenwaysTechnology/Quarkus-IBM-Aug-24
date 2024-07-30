package com.ibm;

import io.smallrye.mutiny.Uni;

class Auth {

    public  static  Uni auth(String name,String password){
        if(name.equals("admin") && password.equals("admin")){
            return Uni.createFrom().item("Login success");
        }
        return Uni.createFrom().item("Login failed");
    }
}

public class Login {
    public static void main(String[] args) {
         Auth.auth("admin","admin").subscribe().with(System.out::println);
        Auth.auth("foo","admin").subscribe().with(System.out::println);

    }
}
