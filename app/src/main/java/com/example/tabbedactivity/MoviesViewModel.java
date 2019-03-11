package com.example.tabbedactivity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.tabbedactivity.model.Movie;

import java.util.List;


public class MoviesViewModel extends AndroidViewModel {

    private MoviesRepositores mRepository;

    public MoviesViewModel(Application application) {
        super(application);
        mRepository = new MoviesRepositores(application);
    }

    public LiveData<List<Movie>> getMovies() { return mRepository.getMovies(); }

    public LiveData<List<Movie>> getAllMoviesyear2011() { return mRepository.getAllMoviesyear2011(); }


    public LiveData<List<Movie>> getMovieId() { return mRepository.getMovieid(); }



}

