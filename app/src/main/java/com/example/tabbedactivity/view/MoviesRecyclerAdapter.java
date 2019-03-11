package com.example.tabbedactivity.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tabbedactivity.GlideApp;
import com.example.tabbedactivity.model.Movie;
import com.example.tabbedactivity.R;

import java.util.ArrayList;
import java.util.List;


public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MoviesRecyclerAdapter.MovieViewHolder>{


    List<Movie> list= new ArrayList<>();

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemMovie = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(itemMovie);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final Movie movie = list.get(position);

        holder.MovieTitle.setText(movie.Title);
        holder.MovieYear.setText(movie.Year);
        holder.MovieId.setText("ID :" +movie.imdbID);
        holder.MovieType.setText(movie.Type);
        GlideApp.with(holder.itemView.getContext()).load(movie.Poster).into(holder.image_movie);
    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    public void setList(List<Movie> movies){
        this.list = movies;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView MovieYear;
        private TextView MovieTitle;
        private TextView MovieId;
        private TextView MovieType;
        private ImageView image_movie;


        MovieViewHolder(View itemMovie) {
            super(itemMovie);
            MovieTitle= itemMovie.findViewById(R.id.movie_title);
            MovieYear = itemMovie.findViewById(R.id.movie_year);
            MovieId= itemMovie.findViewById(R.id.movie_id);
            MovieType= itemMovie.findViewById(R.id.movie_type);
            image_movie = itemMovie.findViewById(R.id.image_movie);
        }
    }
}
