package com.dwirandyh.dependencyinjection;

import dagger.Component;

@Component(modules = MemoryCardModule.class)
public interface SmartPhoneComponent {

    SmartPhone getSmartPhone();
}
