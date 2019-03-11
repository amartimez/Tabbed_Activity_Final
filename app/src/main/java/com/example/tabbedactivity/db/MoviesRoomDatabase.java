package com.example.tabbedactivity.db;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.tabbedactivity.model.Movie;


@Database(entities = {Movie.class}, version = 1)
public abstract class MoviesRoomDatabase extends RoomDatabase {

    public abstract MoviesDAO moviesDAO();

    private static volatile MoviesRoomDatabase INSTANCE;

    public static MoviesRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MoviesRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MoviesRoomDatabase.class, "Movies_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}