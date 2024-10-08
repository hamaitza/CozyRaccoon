package com.example.tw_movie_rental.service;

import com.example.tw_movie_rental.Model.Author;
import com.example.tw_movie_rental.Model.Comic;
import com.example.tw_movie_rental.Model.Movie;
import com.example.tw_movie_rental.Model.Publisher;
import com.example.tw_movie_rental.repository.ComicRepository;
import com.example.tw_movie_rental.response.ComicResponse;
import com.example.tw_movie_rental.response.MovieResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
public class ComicServiceImpl implements ComicService {
    final
    private ComicRepository comicRepository;

    public ComicServiceImpl(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public ResponseEntity<ComicResponse> getComics() throws SQLException {
        Map<Integer, Integer> offerings = new LinkedHashMap<>();
        offerings.put(1,2);
        offerings.put(3,3);
        offerings.put(5,1);
        offerings.put(7,4);
        Collection<Comic> comicList = new ArrayList<>();
        for(int i=0;i<comicRepository.findAll().size();i++)
            comicList.add(comicRepository.findAll().get(i));
        System.out.println(Arrays.toString(comicList.iterator().next().getImage()));
        return new ResponseEntity<ComicResponse>(new ComicResponse(comicList,offerings), HttpStatus.OK);
    }
}
