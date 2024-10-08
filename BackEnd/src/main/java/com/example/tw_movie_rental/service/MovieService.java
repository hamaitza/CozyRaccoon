package com.example.tw_movie_rental.service;

import com.example.tw_movie_rental.response.MovieResponse;
import org.springframework.http.ResponseEntity;

public interface MovieService {
    public ResponseEntity<MovieResponse> getMovies();
}
