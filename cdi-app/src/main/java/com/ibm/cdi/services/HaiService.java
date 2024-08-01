package com.ibm.cdi.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class HaiService {

    public String sayHai(){
        return  "Hai";
    }
}
