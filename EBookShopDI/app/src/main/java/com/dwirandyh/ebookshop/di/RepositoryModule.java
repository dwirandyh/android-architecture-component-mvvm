package com.dwirandyh.ebookshop.di;

import android.app.Application;

import com.dwirandyh.ebookshop.model.EBookShopRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    EBookShopRepository provideEBookShopRepository(Application application){
        return new EBookShopRepository(application);
    }
}
