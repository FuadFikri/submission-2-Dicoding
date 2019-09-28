package com.fikri.moviecataloguedua.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fikri.moviecataloguedua.DetailMovieActivity;
import com.fikri.moviecataloguedua.Movie;
import com.fikri.moviecataloguedua.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.GridViewHolder> {
    private ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_movie, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(movies.get(position).getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPoster;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_movie_poster);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Movie movie = getMovies().get(getAdapterPosition());
            Intent moveWithObjectIntent = new Intent(itemView.getContext(), DetailMovieActivity.class);
            moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie);
            v.getContext().startActivity(moveWithObjectIntent);
        }
    }
}
