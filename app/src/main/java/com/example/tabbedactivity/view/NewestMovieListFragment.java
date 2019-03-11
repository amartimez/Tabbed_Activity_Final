package com.example.tabbedactivity.view;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabbedactivity.MoviesViewModel;
import com.example.tabbedactivity.R;
import com.example.tabbedactivity.model.Movie;

import java.util.List;


public class NewestMovieListFragment extends Fragment {
    MoviesViewModel movieViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.section_label);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final MoviesRecyclerAdapter moviesRecyclerAdapter = new MoviesRecyclerAdapter();
        recyclerView.setAdapter(moviesRecyclerAdapter);

        movieViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);

        movieViewModel.getAllMoviesyear2011().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                moviesRecyclerAdapter.setList(movies);
                moviesRecyclerAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}
