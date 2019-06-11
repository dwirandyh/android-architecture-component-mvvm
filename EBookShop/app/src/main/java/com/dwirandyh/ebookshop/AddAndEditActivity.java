package com.dwirandyh.ebookshop;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.dwirandyh.ebookshop.databinding.ActivityAddAndEditBinding;
import com.dwirandyh.ebookshop.model.Book;

public class AddAndEditActivity extends AppCompatActivity {

    private Book book;
    public static final String BOOK_ID = "bookId";
    public static final String BOOK_NAME= "bookName";
    public static final String UNIT_PRICE ="unitPrice";

    private ActivityAddAndEditBinding activityAddAndEditBinding;
    private AddAndEditActivityClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_and_edit);

        book = new Book();
        activityAddAndEditBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_and_edit);
        activityAddAndEditBinding.setBook(book);

        handlers = new AddAndEditActivityClickHandlers(this);
        activityAddAndEditBinding.setClickHandler(handlers);

        Intent intent = getIntent();
        if (intent.hasExtra(BOOK_ID)){
            setTitle("Edit Book");
            book.setBookName(intent.getStringExtra(BOOK_NAME));
            book.setUnitPrice(intent.getIntExtra(UNIT_PRICE, 0));
        }else{
            setTitle("Add New Book");
        }

    }

    public class AddAndEditActivityClickHandlers{
        Context context;

        public AddAndEditActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onSubmitButtonClicked(View view){
            if (book.getBookName() == null || TextUtils.isEmpty(book.getBookName())){
                Toast.makeText(context, "Name field cannot be empty", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent();
                intent.putExtra(BOOK_NAME, book.getBookName());
                intent.putExtra(UNIT_PRICE, book.getUnitPrice());
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}
