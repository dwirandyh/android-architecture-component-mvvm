package com.dwirandyh.dependencyinjection;

import android.util.Log;

import javax.inject.Inject;

public class Akalin implements Battery {

    private static final String TAG = "Smartphone";

    @Inject
    public Akalin() {
    }

    @Override
    public void showType() {
        Log.d(TAG, "this is akalin battery");
    }
}
