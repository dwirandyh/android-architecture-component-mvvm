package com.dwirandyh.ebookshop.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BookDAO {

    @Insert
    void insert(Book book);

    @Update
    void update(Book book);

    @Delete
    void delete(Book book);

    @Query("select * from books_table")
    LiveData<List<Book>> getAllBooks();

    @Query("select * from books_table where category_id==:categoryId")
    LiveData<List<Book>> getBooks(int categoryId);

}
