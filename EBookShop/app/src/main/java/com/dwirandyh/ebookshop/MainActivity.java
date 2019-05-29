package com.dwirandyh.ebookshop;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.dwirandyh.ebookshop.databinding.ActivityMainBinding;
import com.dwirandyh.ebookshop.model.Book;
import com.dwirandyh.ebookshop.model.Category;
import com.dwirandyh.ebookshop.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private ArrayList<Category> categoryList;
    private ArrayList<Book> bookList;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers handlers;
    private Category selectedCategory;
    private RecyclerView bookRecyclerView;
    private BooksAdapter booksAdapter;
    private int selectedBookId = 0;

    public static final int ADD_BOOK_REQUEST_CODE = 1;
    public static final int EDIT_BOOK_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainActivityClickHandlers();
        activityMainBinding.setClickHandlers(handlers);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                categoryList = (ArrayList<Category>) categories;
//                for (Category category : categories){
//                    Log.i("MyTAG", category.getCategoryName());
//                }
                showOnSpinner();
            }
        });
    }

    private void showOnSpinner() {
        ArrayAdapter<Category> categoryArrayAdapter = new ArrayAdapter<Category>(this, R.layout.spinner_item, categoryList);
        categoryArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        activityMainBinding.setSpinnerAdapter(categoryArrayAdapter);
    }

    private void loadBooksArrayList(int categoryId) {
        mainActivityViewModel.getBooksOfASelectedaCateogry(categoryId).observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                bookList = (ArrayList<Book>) books;

                loadRecyclerView();
            }
        });
    }

    private void loadRecyclerView() {
        bookRecyclerView = activityMainBinding.secondaryLayout.rvBooks;
        bookRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookRecyclerView.setHasFixedSize(true);

        booksAdapter = new BooksAdapter();
        bookRecyclerView.setAdapter(booksAdapter);

        booksAdapter.setBooks(bookList);
        booksAdapter.setOnItemClickListener(new BooksAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Book book) {
                selectedBookId = book.getBookId();
                Intent intent = new Intent(MainActivity.this, AddAndEditActivity.class);
                intent.putExtra(AddAndEditActivity.BOOK_ID, selectedBookId);
                intent.putExtra(AddAndEditActivity.BOOK_NAME, book.getBookName());
                intent.putExtra(AddAndEditActivity.UNIT_PRICE, book.getUnitPrice());
                startActivityForResult(intent, EDIT_BOOK_REQUEST_CODE);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                Book bookToDelete = bookList.get(viewHolder.getAdapterPosition());
                mainActivityViewModel.deleteNewBook(bookToDelete);
            }
        }).attachToRecyclerView(bookRecyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int selectedCategoryId = selectedCategory.getId();
        if (requestCode == ADD_BOOK_REQUEST_CODE && resultCode == RESULT_OK){
            Book book = new Book();
            book.setCategoryId(selectedCategoryId);
            book.setBookName(data.getStringExtra(AddAndEditActivity.BOOK_NAME));
            book.setUnitPrice(data.getIntExtra(AddAndEditActivity.UNIT_PRICE, 0));
            mainActivityViewModel.addNewBook(book);
        }else if (requestCode == EDIT_BOOK_REQUEST_CODE && resultCode == RESULT_OK){
            Book book = new Book();
            book.setCategoryId(selectedCategoryId);
            book.setBookName(data.getStringExtra(AddAndEditActivity.BOOK_NAME));
            book.setUnitPrice(data.getIntExtra(AddAndEditActivity.UNIT_PRICE, 0));
            book.setBookId(selectedBookId);
            mainActivityViewModel.updateNewBook(book);
        }
    }

    public class MainActivityClickHandlers {
        public void onFABClicked(View view) {
            Intent intent = new Intent(MainActivity.this, AddAndEditActivity.class);
            startActivityForResult(intent, ADD_BOOK_REQUEST_CODE);
        }

        public void onSelectItem(AdapterView<?> parent, View view, int pos, long id) {
            selectedCategory = (Category) parent.getItemAtPosition(pos);
            loadBooksArrayList(selectedCategory.getId());
        }
    }

}
