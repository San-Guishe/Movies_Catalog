package com.example.movie_features;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_features.databinding.ItemMovieBinding;

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    ItemMovieBinding itemMovieBinding;

    public MoviesViewHolder(ItemMovieBinding binding) {
        super(binding.getRoot());
        itemMovieBinding = binding;
    }

    public void decorateWith(Movie model) {
        Glide.with(itemView.getContext()).load(model.getPoster()).into(itemMovieBinding.ivPoster);
        itemMovieBinding.title.setText(model.getTittle());
    }
}
