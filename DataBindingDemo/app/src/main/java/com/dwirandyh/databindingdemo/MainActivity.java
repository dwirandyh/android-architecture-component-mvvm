package com.dwirandyh.databindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dwirandyh.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setStudent(getCurrentStudent());

        handlers = new MainActivityClickHandlers(this);
        activityMainBinding.setClickHandler(handlers);
    }

    private Student getCurrentStudent(){
        Student student = new Student();
        student.setStudentName("Dwi Randy H");
        student.setStudentEmail("dwirandyherdinanto@gmail.com");
        return student;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class MainActivityClickHandlers {
        Context context;

        public MainActivityClickHandlers(Context context){
            this.context = context;
        }

        public void onEnrollButtonClicked(View view){
            Toast.makeText(context, "Entroll Clicked", Toast.LENGTH_LONG).show();
        }

        public void onCancelButtonClicked(View view){
            Toast.makeText(context, "Cancel Clicked", Toast.LENGTH_LONG).show();
        }
    }
}
