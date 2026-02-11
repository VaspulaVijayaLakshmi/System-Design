package models;

import java.util.UUID;

public class Movie {

    String movieId;
    String name;
    long duration;

    public Movie( long duration, String name) {
        this.movieId = UUID.randomUUID().toString();
        this.duration = duration;
        this.name=name;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }



}
