package com.dwirandyh.roomhomeworkexercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.EnumMap;

public class AddNewStudentActivity extends AppCompatActivity {

    private Button submitButton;
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText countryEdiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);

        nameEditText = findViewById(R.id.et_name);
        emailEditText = findViewById(R.id.et_email);
        countryEdiText = findViewById(R.id.et_country);
        submitButton = findViewById(R.id.btnSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nameEditText.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Name field cannot be empty", Toast.LENGTH_SHORT).show();
                }else{
                    String name = nameEditText.getText().toString();
                    String email = emailEditText.getText().toString();
                    String country = countryEdiText.getText().toString();

                    Intent intent = new Intent();
                    intent.putExtra("STUDENT",new Student(0, name, email, country, ""));
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
