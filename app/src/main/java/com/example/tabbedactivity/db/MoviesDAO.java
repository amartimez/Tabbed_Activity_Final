package com.example.tabbedactivity.db;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.tabbedactivity.model.Movie;

import java.util.List;


@Dao
public abstract class MoviesDAO {

    @Insert
    public abstract void insert(Movie movie);

    @Query("SELECT * FROM movie")
    public abstract LiveData<List<Movie>> getAllMovies();



    @Query("SELECT * FROM movie ORDER BY title")
    public abstract LiveData<List<Movie>> getAllMoviesOrderedByTitle();



    @Query("SELECT * FROM movie WHERE id = :id")
    public abstract LiveData<Movie> getMovie(int id);



    @Query("DELETE FROM movie")
    public abstract void deleteAllMovies();
}