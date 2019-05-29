package com.dwirandyh.ebookshop;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dwirandyh.ebookshop.databinding.BookListItemBinding;
import com.dwirandyh.ebookshop.model.Book;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {

    private OnItemClickListener onItemClickListener;
    private ArrayList<Book> books = new ArrayList<>();

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        BookListItemBinding bookListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.book_list_item, viewGroup, false);

        return new BookViewHolder(bookListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int i) {
        Book book = books.get(i);
        bookViewHolder.bookListItemBinding.setBook(book);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{

        private BookListItemBinding bookListItemBinding;

        public BookViewHolder(@NonNull BookListItemBinding bookListItemBinding) {
            super(bookListItemBinding.getRoot());

            this.bookListItemBinding = bookListItemBinding;
            bookListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickedPosition = getAdapterPosition();

                    if (onItemClickListener != null && clickedPosition != RecyclerView.NO_POSITION){
                        onItemClickListener.onItemClick(books.get(clickedPosition));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Book book);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener =listener;
    }
}
