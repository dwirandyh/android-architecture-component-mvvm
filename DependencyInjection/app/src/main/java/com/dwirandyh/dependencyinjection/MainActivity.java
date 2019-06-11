package com.dwirandyh.dependencyinjection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

//        SmartPhoneComponent smartPhoneComponent = DaggerSmartPhoneComponent.create();

//        SmartPhoneComponent smartPhoneComponent = DaggerSmartPhoneComponent.builder()
//                .memoryCardModule(new MemoryCardModule(100)).build();

//        smartPhone = smartPhoneComponent.getSmartPhone();
        //smartPhoneComponent.inject(this);

        App.getApp().getSmartPhoneComponent().inject(this);

        smartPhone.makeACall();

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
