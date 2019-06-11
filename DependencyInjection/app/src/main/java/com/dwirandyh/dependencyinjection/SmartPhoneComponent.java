package com.dwirandyh.dependencyinjection;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MemoryCardModule.class, BatteryModule.class})
public interface SmartPhoneComponent {

    //SmartPhone getSmartPhone();

    // field injectin
    void inject(MainActivity mainActivity);
}
