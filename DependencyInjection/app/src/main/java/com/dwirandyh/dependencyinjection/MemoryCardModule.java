package com.dwirandyh.dependencyinjection;

import android.util.Log;

import dagger.Module;
import dagger.Provides;

@Module
public class MemoryCardModule {

    private int memorySize;
    private static final String TAG ="SmartPhone";

    public MemoryCardModule(int memorySize){
        this.memorySize = memorySize;
    }

    // this module used if you cannot access/modify constructor of class
    @Provides
    MemoryCard provideMemoryCard(){
        Log.d(TAG, " size of the memory size is " + memorySize);
        return new MemoryCard();
    }
}
