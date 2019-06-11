package com.dwirandyh.dependencyinjection;

import dagger.Module;
import dagger.Provides;

@Module
public class BatteryModule {

    @Provides
    Battery provideAkalinBattery(Akalin akalin){
        // invoke showType method before return instance (optional)
        akalin.showType();

        return akalin;
    }
}
