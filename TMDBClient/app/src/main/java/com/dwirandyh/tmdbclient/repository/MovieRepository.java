package com.dwirandyh.tmdbclient.repository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.dwirandyh.tmdbclient.R;
import com.dwirandyh.tmdbclient.model.Movie;
import com.dwirandyh.tmdbclient.model.MovieDBResponse;
import com.dwirandyh.tmdbclient.service.MoviewDataService;
import com.dwirandyh.tmdbclient.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;


    public MovieRepository(Application application){
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData(){
        MoviewDataService moviewDataService = RetrofitInstance.getService();
        Call<MovieDBResponse> call = moviewDataService.getPopularMovies(application.getString(R.string.api_key));

        call.enqueue(new Callback<MovieDBResponse>() {
            @Override
            public void onResponse(Call<MovieDBResponse> call, Response<MovieDBResponse> response) {
                MovieDBResponse movieDBResponse = response.body();

                if (movieDBResponse != null && movieDBResponse.getMovies() != null){
                    movies = (ArrayList<Movie>) response.body().getMovies();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<MovieDBResponse> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
