package com.example.tabbedactivity.api;

import com.example.tabbedactivity.model.MoviesList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OmdbApi {


    @GET("?s=guardians")
    Call<MoviesList> getMovies();
// segun la api la busqueda por titulo es oblicatoria pero puede estar vacia...

    @GET("?s=love&y=2011")
    Call<MoviesList> getAllMoviesyear2011();

    @GET("?s=Game of Thrones&Season=1&Episode=1")
    Call<MoviesList> getMovieId();







}