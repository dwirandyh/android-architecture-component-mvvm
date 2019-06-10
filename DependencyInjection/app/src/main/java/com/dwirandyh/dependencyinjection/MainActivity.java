package com.dwirandyh.dependencyinjection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Battery battery = new Battery();
        MemoryCard memoryCard = new MemoryCard();

        ServiceProvider serviceProvider = new ServiceProvider();
        SIMCard simCard = new SIMCard(serviceProvider);

        SmartPhone smartPhone = new SmartPhone(battery, memoryCard, simCard);

        smartPhone.makeACall();
    }
}
