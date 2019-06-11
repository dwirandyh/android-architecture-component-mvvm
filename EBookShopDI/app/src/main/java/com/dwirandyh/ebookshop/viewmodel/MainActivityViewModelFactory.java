package com.dwirandyh.ebookshop.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.dwirandyh.ebookshop.model.EBookShopRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainActivityViewModelFactory implements ViewModelProvider.Factory {

    private final EBookShopRepository eBookShopRepository;

    @Inject
    public MainActivityViewModelFactory(EBookShopRepository eBookShopRepository) {
        this.eBookShopRepository = eBookShopRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(eBookShopRepository);
    }
}
