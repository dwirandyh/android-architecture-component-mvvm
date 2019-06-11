package com.dwirandyh.dependencyinjection;

import javax.inject.Inject;

public class SIMCard {

    private ServiceProvider serviceProvider;

    @Inject
    public SIMCard(ServiceProvider serviceProvider){
        this.serviceProvider = serviceProvider;
    }
}
