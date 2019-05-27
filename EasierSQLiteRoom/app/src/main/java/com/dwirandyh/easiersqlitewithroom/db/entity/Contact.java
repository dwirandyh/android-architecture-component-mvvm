package com.dwirandyh.easiersqlitewithroom.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

@Entity(tableName = "contacts")
public class Contact {

    @ColumnInfo(name = "contact_name")
    private String name;

    @ColumnInfo(name = "contact_email")
    private String email;

    @ColumnInfo(name = "contact_id")
    @PrimaryKey(autoGenerate = true)
    private Long id;

    /*
    Ignore annotation to tell room to not use this constructor and use other constructor
     */
    @Ignore
    public Contact(){

    }

    public Contact(long id, String name, String email){
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
