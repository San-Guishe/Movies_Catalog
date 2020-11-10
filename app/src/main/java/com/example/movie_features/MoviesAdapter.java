package com.example.movie_features;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_features.databinding.ItemMovieBinding;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {
    private List<Movie> items = new ArrayList<>();

    private Context context;

    public MoviesAdapter(Context context) {
        this.context = context;
    }

    public void setItems(List<Movie> newItems) {
        this.items = newItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MoviesViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MoviesViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(context)));
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder  holder, final int position) {
        holder.decorateWith(items.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onMovieClicked(items.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private MovieClickListener listener;

    public void setMovieClickListener(MovieClickListener listener) {
        this.listener = listener;
    }

    interface MovieClickListener {
        void onMovieClicked(Movie movie);
    }




}
