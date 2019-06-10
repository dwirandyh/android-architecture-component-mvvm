package com.dwirandyh.dependencyinjection;

import android.util.Log;

public class SmartPhone {

    private Battery battery;
    private MemoryCard memoryCard;
    private SIMCard simCard;
    private static final String TAG = "SmartPhone";

    public SmartPhone(Battery battery, MemoryCard memoryCard, SIMCard simCard){
        this.battery = battery;
        this.memoryCard = memoryCard;
        this.simCard = simCard;
    }

    public void makeACall(){
        Log.d(TAG, "Making a call.... ");
    }
}
