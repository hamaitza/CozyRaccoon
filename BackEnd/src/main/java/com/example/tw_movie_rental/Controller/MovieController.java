package com.example.tw_movie_rental.Controller;

import com.example.tw_movie_rental.response.MovieResponse;
import com.example.tw_movie_rental.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= {"*"}, maxAge = 48000, allowCredentials = "false")
@RestController
public class MovieController {
    final
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/movies")
    public ResponseEntity<MovieResponse> getAllMovies()
    {
        return movieService.getMovies();
    }
}
