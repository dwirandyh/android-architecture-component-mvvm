package com.dwirandyh.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Contact extends BaseObservable {
    private int id;
    private String name;
    private String email;

    public Contact(String name, String email){
        this.name = name;
        this.email = email;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}
