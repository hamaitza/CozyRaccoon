package com.example.tw_movie_rental.Controller;

import com.example.tw_movie_rental.Model.Invoice;
import com.example.tw_movie_rental.response.ComicResponse;
import com.example.tw_movie_rental.service.ComicService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin(origins= {"*"}, maxAge = 92000, allowCredentials = "false")
@RestController
public class ComicController {

    final
    ComicService comicService;
    public ComicController(ComicService comicService) {
        this.comicService = comicService;
    }

    @GetMapping(value = "/comics")
    public ResponseEntity<ComicResponse> getAllComics() throws SQLException {
        return comicService.getComics();
    }
}
