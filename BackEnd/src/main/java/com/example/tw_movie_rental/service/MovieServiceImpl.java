package com.example.tw_movie_rental.service;

import com.example.tw_movie_rental.Model.Movie;
import com.example.tw_movie_rental.repository.MovieRepository;
import com.example.tw_movie_rental.response.MovieResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService{
   final
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public ResponseEntity<MovieResponse> getMovies() {
        Collection<Movie> movieList = new ArrayList<>();
        Map<Integer, Integer> offerings = new LinkedHashMap<>();
        offerings.put(1,2);
        offerings.put(3,3);
        offerings.put(5,1);
        offerings.put(7,4);
        for(int i=0;i<movieRepository.findAll().size();i++)
            movieList.add(movieRepository.findAll().get(i));
        return new ResponseEntity<MovieResponse>(new MovieResponse(movieList,offerings), HttpStatus.OK);

    }
}
