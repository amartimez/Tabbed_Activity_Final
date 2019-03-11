package com.example.tabbedactivity;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.example.tabbedactivity.api.OmdbApi;
import com.example.tabbedactivity.api.OmdbModule;
import com.example.tabbedactivity.db.MoviesDAO;
import com.example.tabbedactivity.model.Movie;
import com.example.tabbedactivity.model.MoviesList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MoviesRepositores {

    private OmdbApi mMoviesApi;


    public MoviesRepositores(Application application){
        mMoviesApi = OmdbModule.getAPI();
    }


    LiveData<List<Movie>> getMovies() {
        final MutableLiveData<List<Movie>> lista = new MutableLiveData<>();

        mMoviesApi.getMovies().enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                lista.setValue(response.body().Search);
                                           }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
            }
        });



        return lista;
    }

    LiveData<List<Movie>> getAllMoviesyear2011() {
        final MutableLiveData<List<Movie>> lista = new MutableLiveData<>();

        mMoviesApi.getAllMoviesyear2011().enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                lista.setValue(response.body().Search);
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
            }
        });



        return lista;
    }
    LiveData<List<Movie>> getMovieid() {
        final MutableLiveData<List<Movie>> lista = new MutableLiveData<>();

        mMoviesApi.getMovieId().enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                lista.setValue(response.body().Search);
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
            }
        });



        return lista;
    }






    public void insert(Movie movie) {
        new InsertAsyncTask((MoviesDAO) mMoviesApi).execute(movie);
    }

    private static class InsertAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MoviesDAO mAsyncTaskDao;

        InsertAsyncTask(MoviesDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Movie... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }




    public void deleteAllMovies(){
        new DeleteAsyncTask((MoviesDAO) mMoviesApi).execute();
    }

    private static class DeleteAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MoviesDAO mAsyncTaskDao;

        DeleteAsyncTask(MoviesDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Movie... poems) {
            mAsyncTaskDao.deleteAllMovies();
            return null;
        }
    }


}