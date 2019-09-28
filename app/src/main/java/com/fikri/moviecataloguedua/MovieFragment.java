package com.fikri.moviecataloguedua;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fikri.moviecataloguedua.adapter.MovieAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();
    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie,container,false);
        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        list.addAll(MovieData.getMovieList());
        showRecyclerGrid();
        return view;
    }

    private void showRecyclerGrid(){
        rvMovies.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        MovieAdapter movieAdapter= new MovieAdapter(list);
        rvMovies.setAdapter(movieAdapter);
    }

}
