package com.dwirandyh.ebookshop;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.dwirandyh.ebookshop.model.Book;

import java.util.ArrayList;

public class BooksDiffCallback extends DiffUtil.Callback {

    ArrayList<Book> oldBookList;
    ArrayList<Book> newBookList;

    public BooksDiffCallback(ArrayList<Book> oldBookList, ArrayList<Book> newBookList) {
        this.oldBookList = oldBookList;
        this.newBookList = newBookList;
    }

    @Override
    public int getOldListSize() {
        return oldBookList == null ? 0 : oldBookList.size();
    }

    @Override
    public int getNewListSize() {
        return newBookList == null ? 0 : newBookList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldBookPosition, int newBookPosition) {
        return oldBookList.get(oldBookPosition).getBookId() == newBookList.get(newBookPosition).getBookId();
    }

    @Override
    public boolean areContentsTheSame(int oldBookPosition, int newBookPosition) {
        return oldBookList.get(oldBookPosition).equals(newBookList.get(newBookPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldBookPosition, int newBookPosition) {
        return super.getChangePayload(oldBookPosition, newBookPosition);
    }
}
