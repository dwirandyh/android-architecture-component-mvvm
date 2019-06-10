package com.dwirandyh.dependencyinjection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    SmartPhone smartPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Battery battery = new Battery();
//        MemoryCard memoryCard = new MemoryCard();
//
//        ServiceProvider serviceProvider = new ServiceProvider();
//        SIMCard simCard = new SIMCard(serviceProvider);
//
//        SmartPhone smartPhone = new SmartPhone(battery, memoryCard, simCard);

        SmartPhoneComponent smartPhoneComponent = DaggerSmartPhoneComponent.create();

//        smartPhone = smartPhoneComponent.getSmartPhone();
        smartPhoneComponent.inject(this);

        smartPhone.makeACall();
    }
}
