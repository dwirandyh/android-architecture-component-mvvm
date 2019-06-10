package com.dwirandyh.dependencyinjection;

import dagger.Component;

@Component(modules = {MemoryCardModule.class, BatteryModule.class})
public interface SmartPhoneComponent {

    SmartPhone getSmartPhone();
}
