package com.example.tw_movie_rental.response;
import com.example.tw_movie_rental.Model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;
import java.util.Map;

public class MovieResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Collection<Movie> movies;

    public Map<Integer, Integer> getOfferings() {
        return offerings;
    }

    private Map<Integer, Integer> offerings;

    public MovieResponse(Collection<Movie> movies, Map<Integer, Integer> offerings) {
        this.movies = movies;
        this.offerings = offerings;
    }

    public Collection<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Collection<Movie> movies) {
        this.movies = movies;
    }
}
