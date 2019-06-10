package com.dwirandyh.ebookshop;

import android.app.Application;

import com.dwirandyh.ebookshop.di.AppModule;
import com.dwirandyh.ebookshop.di.DaggerEBookShopComponent;
import com.dwirandyh.ebookshop.di.EBookShopComponent;

public class App extends Application {
    private static App app;
    private EBookShopComponent eBookShopComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;

        eBookShopComponent = DaggerEBookShopComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static App getApp(){
        return app;
    }

    public EBookShopComponent geteBookShopComponent() {
        return eBookShopComponent;
    }
}
