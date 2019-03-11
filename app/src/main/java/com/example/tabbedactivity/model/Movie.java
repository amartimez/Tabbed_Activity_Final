package com.example.tabbedactivity.model;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
@Entity
public class Movie  {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String Title;
    public String Year;
    public String imdbID;
    public String Type;
    public String Poster;
}
