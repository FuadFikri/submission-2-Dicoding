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
import com.fikri.moviecataloguedua.DetailTvShowActivity;
import com.fikri.moviecataloguedua.Movie;
import com.fikri.moviecataloguedua.R;
import com.fikri.moviecataloguedua.TvShow;

import java.util.ArrayList;

public class TvShowAdapter  extends RecyclerView.Adapter<TvShowAdapter.GridViewHolder>  {

    private ArrayList<TvShow> tvShows;

    public TvShowAdapter(ArrayList<TvShow> tvShows) {
        this.tvShows = tvShows;
    }

    public ArrayList<TvShow> getTvShows() {
        return tvShows;
    }

    @NonNull
    @Override
    public TvShowAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_tv_show, viewGroup, false);
        return new TvShowAdapter.GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.GridViewHolder gridViewHolder, int i) {
        Glide.with(gridViewHolder.itemView.getContext())
                .load(tvShows.get(i).getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(gridViewHolder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        ImageView imgPoster;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_tv_show_poster);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            TvShow tvShow= getTvShows().get(getAdapterPosition());
            Intent moveWithObjectIntent = new Intent(itemView.getContext(), DetailTvShowActivity.class);
            moveWithObjectIntent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShow);
            v.getContext().startActivity(moveWithObjectIntent);
        }
    }
}
