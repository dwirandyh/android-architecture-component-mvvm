package com.anushka.androidtutz.contactmanager.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.anushka.androidtutz.contactmanager.db.ContactsAppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Provides
    @Singleton
    ContactsAppDatabase provideContactsAppDatabase(Application application){
        return Room.databaseBuilder(application,ContactsAppDatabase.class,"ContactDB").build();
    }
}
