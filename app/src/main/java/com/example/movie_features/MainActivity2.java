package com.example.movie_features;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.movie_features.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Movie movie = getIntent().getParcelableExtra("EXTRA");
        setupToolbar(movie);
        setData(movie);
    }
    private void setupToolbar(Movie movie) {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.toolbar.setTitle(movie.getTittle());
    }
    private void setData(Movie movie) {
        Glide.with(this).load(movie.getPoster()).into(binding.ivPoster);
        binding.tvDirector.setText(getString(R.string.movie_director,movie.getDirector()));
        binding.tvGenere.setText(getString(R.string.movie_genere,movie.getGenere()));
        binding.tvYear.setText(getString(R.string.movie_year, movie.getYear()));
        binding.tvSummary.setText(movie.getSummary());
    }


}