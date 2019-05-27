package com.dwirandyh.introduction;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int clickCount = 0;
    private MutableLiveData<Integer> countLIveData = new MutableLiveData<>();

    public MutableLiveData<Integer> getInitialCount(){
        /*
        There are two methods to upate the value of a MutableLiveData instance.
        setValue() and the postValue();
        this setValue method must be called from the main thread.
        if you need to set a value from a background thread you should use the postValue() method
         */

        countLIveData.setValue(clickCount);
        return countLIveData;
    }

    public void getCurrentCount(){
        clickCount+=1;
        countLIveData.setValue(clickCount);
    }
}
