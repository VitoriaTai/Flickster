package com.example.vitoriatai.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String posterPath;
    String tittle;
    String overview;
    Double voteAverage;
    String backdropPath;
    int movieId;

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        tittle = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        voteAverage = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
        backdropPath = jsonObject.getString("backdrop_path");

    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException{
        List<Movie> movies = new ArrayList<>();
        for (int i=0; i<movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTittle(){
        return tittle;

    }

    public String getOverview(){
        return overview;

    }

    public double getVoteAverage(){
        return voteAverage;
    }

    public int getMovieId(){
        return movieId;
    }
}

