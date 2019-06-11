package com.dwirandyh.tmdbclient.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dwirandyh.tmdbclient.R;
import com.dwirandyh.tmdbclient.databinding.ActivityMovieBinding;
import com.dwirandyh.tmdbclient.model.Movie;

public class MovieActivity extends AppCompatActivity {

    private Movie movie;
    private ActivityMovieBinding activityMovieBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        activityMovieBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie);

        Toolbar toolbar = activityMovieBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        if (intent.hasExtra("movie")) {
            movie = getIntent().getParcelableExtra("movie");
            activityMovieBinding.setMovie(movie);
        }
    }

}
