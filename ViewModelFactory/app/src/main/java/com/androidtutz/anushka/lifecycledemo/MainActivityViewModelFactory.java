package com.androidtutz.anushka.lifecycledemo;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {
    private int initialValue = 0;

    public MainActivityViewModelFactory(int initialValue) {
        this.initialValue = initialValue;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new MainActivityViewModel(initialValue);
    }
}
