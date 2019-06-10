package com.dwirandyh.ebookshop.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.dwirandyh.ebookshop.model.Book;
import com.dwirandyh.ebookshop.model.Category;
import com.dwirandyh.ebookshop.model.EBookShopRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private EBookShopRepository eBookShopRepository;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Book>> booksOfASelectedaCateogry;

    public MainActivityViewModel(EBookShopRepository eBookShopRepository) {

        this.eBookShopRepository = eBookShopRepository;
    }

    public LiveData<List<Category>> getAllCategories() {
        allCategories = eBookShopRepository.getCategories();
        return allCategories;
    }

    public LiveData<List<Book>> getBooksOfASelectedaCateogry(int categoryId) {
        booksOfASelectedaCateogry =  eBookShopRepository.getBooks(categoryId);
        return booksOfASelectedaCateogry;
    }

    public void addNewBook(Book book){
        eBookShopRepository.insertBook(book);
    }

    public void updateNewBook(Book book){
        eBookShopRepository.updateBook(book);
    }

    public void deleteNewBook(Book book){
        eBookShopRepository.deleteBook(book);
    }
}
