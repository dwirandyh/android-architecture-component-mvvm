package com.dwirandyh.ebookshop.di;

import com.dwirandyh.ebookshop.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface EBookShopComponent {

    void inject(MainActivity mainActivity);
}
