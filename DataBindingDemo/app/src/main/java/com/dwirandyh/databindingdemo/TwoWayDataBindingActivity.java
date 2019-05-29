package com.dwirandyh.databindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dwirandyh.databindingdemo.databinding.ActivityTwoWayDataBindingBinding;

public class TwoWayDataBindingActivity extends AppCompatActivity {

    private ActivityTwoWayDataBindingBinding activityTwoWayDataBindingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_way_data_binding);

        Contact contact = new Contact("Randy", "dwirandyherdinanto@gmail.com");

        activityTwoWayDataBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_data_binding);
        activityTwoWayDataBindingBinding.setContact(contact);
    }
}
