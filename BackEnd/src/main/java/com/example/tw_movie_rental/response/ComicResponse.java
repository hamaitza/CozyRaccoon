package com.example.tw_movie_rental.response;

import com.example.tw_movie_rental.Model.Comic;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ComicResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Collection<Comic> comics;

    public Map<Integer, Integer> getOfferings() {
        return offerings;
    }

    public void setOfferings(Map<Integer, Integer> offerings) {
        this.offerings = offerings;
    }

    private Map<Integer, Integer> offerings;

    public ComicResponse(Collection<Comic> comics, Map<Integer, Integer> offerings) {
        this.comics = comics;
        this.offerings=offerings;
    }

    public Collection<Comic> getComics() {
        return comics;
    }

    public void setComics(Collection<Comic> comics) {
        this.comics = comics;
    }
}
