package com.dwirandyh.dependencyinjection;

import dagger.Component;

@Component
public interface SmartPhoneComponent {

    SmartPhone getSmartPhone();
}
