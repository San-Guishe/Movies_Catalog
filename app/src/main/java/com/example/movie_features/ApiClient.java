package com.example.movie_features;

import android.content.Context;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    Retrofit retrofit;
    Context context;

    public ApiClient(Context context) {
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl("https://marioguillermo.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<List<Movie>> getMovies() {
        Api service = retrofit.create(Api.class);
        return service.getMovies();
    }

}
