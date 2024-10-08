package com.example.tw_movie_rental.repository;

import com.example.tw_movie_rental.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Object> {

}
