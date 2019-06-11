package com.anushka.androidtutz.contactmanager;

import android.app.Application;

import com.anushka.androidtutz.contactmanager.di.ApplicationModule;
import com.anushka.androidtutz.contactmanager.di.ContactAppComponent;
import com.anushka.androidtutz.contactmanager.di.DaggerContactAppComponent;

public class App extends Application {

    private static App app;
    private ContactAppComponent contactAppComponent;

    public static App getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;

        contactAppComponent = DaggerContactAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ContactAppComponent getContactAppComponent() {
        return contactAppComponent;
    }
}
