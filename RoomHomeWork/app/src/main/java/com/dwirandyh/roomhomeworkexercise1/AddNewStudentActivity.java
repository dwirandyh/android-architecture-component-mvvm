package com.dwirandyh.roomhomeworkexercise1;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dwirandyh.roomhomeworkexercise1.databinding.ActivityAddNewStudentBinding;

import java.util.EnumMap;

public class AddNewStudentActivity extends AppCompatActivity {

//    private Button submitButton;
//    private EditText nameEditText;
//    private EditText emailEditText;
//    private EditText countryEdiText;

    private ActivityAddNewStudentBinding activityAddNewStudentBinding;
    private AddNewStudentActivityClickHandler clickHandler;

    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);

        student = new Student();
        activityAddNewStudentBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_student);
        activityAddNewStudentBinding.setStudent(student);

        clickHandler = new AddNewStudentActivityClickHandler(this);
        activityAddNewStudentBinding.setClickHandler(clickHandler);

//        nameEditText = findViewById(R.id.et_name);
//        emailEditText = findViewById(R.id.et_email);
//        countryEdiText = findViewById(R.id.et_country);
//        submitButton = findViewById(R.id.btnSubmit);
//
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (TextUtils.isEmpty(nameEditText.getText().toString())){
//
//                }else{
//                    String name = nameEditText.getText().toString();
//                    String email = emailEditText.getText().toString();
//                    String country = countryEdiText.getText().toString();
//
//
//                }
//            }
//        });
    }

    public class AddNewStudentActivityClickHandler{
        Context context;

        AddNewStudentActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onSubmitClicked(View view){
            if (student.getName() == null || TextUtils.isEmpty(student.getName())) {
                Toast.makeText(getApplicationContext(), "Name field cannot be empty", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent();
                intent.putExtra("NAME", student.getName());
                intent.putExtra("EMAIL", student.getEmail());
                intent.putExtra("COUNTRY", student.getCountry());
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}
