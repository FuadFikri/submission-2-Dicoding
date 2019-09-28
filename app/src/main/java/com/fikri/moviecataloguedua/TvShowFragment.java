package com.fikri.moviecataloguedua;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fikri.moviecataloguedua.adapter.TvShowAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    private RecyclerView rvTvShows;
    private ArrayList<TvShow> list = new ArrayList<>();

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_show,container,false);
        rvTvShows = view.findViewById(R.id.rv_tv_shows);
        rvTvShows.setHasFixedSize(true);

        list.addAll(TvShowData.getTvShowData());
        showRecyclerGrid();
        return view;
    }

    private void showRecyclerGrid(){
        rvTvShows.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        TvShowAdapter tvShowAdapter = new TvShowAdapter(list);
        rvTvShows.setAdapter(tvShowAdapter);
    }

}
