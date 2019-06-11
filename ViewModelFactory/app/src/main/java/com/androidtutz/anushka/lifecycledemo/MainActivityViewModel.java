package com.androidtutz.anushka.lifecycledemo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int clickCount = 0;
    private int initialValue = 0;

    private MutableLiveData<Integer> countLiveData=new MutableLiveData<>();

    public MainActivityViewModel(int initialValue) {
        this.initialValue = initialValue;
    }

    public MutableLiveData<Integer> getInitialCount() {

        countLiveData.setValue(clickCount);
        return countLiveData;
    }

    public void getCurrentCount() {

        clickCount += 1;
        countLiveData.setValue(clickCount + initialValue);

    }
}
