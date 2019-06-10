package com.dwirandyh.dependencyinjection;

import dagger.Module;
import dagger.Provides;

@Module
public class MemoryCardModule {

    @Provides
    MemoryCard provideMemorycard(){
        return new MemoryCard();
    }
}
