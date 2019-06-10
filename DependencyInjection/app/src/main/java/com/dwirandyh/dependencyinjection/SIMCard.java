package com.dwirandyh.dependencyinjection;

public class SIMCard {

    private ServiceProvider serviceProvider;

    public SIMCard(ServiceProvider serviceProvider){
        this.serviceProvider = serviceProvider;
    }
}
