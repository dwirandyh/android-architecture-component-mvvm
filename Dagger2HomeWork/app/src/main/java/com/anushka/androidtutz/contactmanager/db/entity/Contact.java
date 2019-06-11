package com.anushka.androidtutz.contactmanager.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "contacts")
public class Contact {


    @ColumnInfo(name="contact_name")
    private String name;

    @ColumnInfo(name="contact_email")
    private String email;

    @ColumnInfo(name="contact_id")
    @PrimaryKey(autoGenerate =true)
    private long id;


    @Ignore
    public Contact() {
    }



    public Contact(long id, String name, String email) {

        this.name = name;
        this.email = email;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
