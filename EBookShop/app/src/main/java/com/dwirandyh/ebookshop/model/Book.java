package com.dwirandyh.ebookshop.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.dwirandyh.ebookshop.BR;

import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(tableName = "books_table", foreignKeys = @ForeignKey(entity = Category.class,
        parentColumns = "id", childColumns = "category_id", onDelete = CASCADE))
public class Book extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    private int bookId;

    @ColumnInfo(name = "book_name")
    private String bookName;

    @ColumnInfo(name = "unit_price")
    private int unitPrice;

    @ColumnInfo(name = "category_id", index = true)
    private int categoryId;

    @Ignore
    public Book() {
    }

    public Book(int bookId, String bookName, int unitPrice, int categoryId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
    }

    @Bindable
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
        notifyPropertyChanged(BR.bookId);

    }

    @Bindable
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        notifyPropertyChanged(BR.bookName);

    }

    @Bindable
    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
        notifyPropertyChanged(BR.unitPrice);

    }

    @Bindable
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        notifyPropertyChanged(BR.categoryId);

    }


}

