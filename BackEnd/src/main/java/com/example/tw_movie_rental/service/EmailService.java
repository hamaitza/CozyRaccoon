package com.example.tw_movie_rental.service;


import com.example.tw_movie_rental.Model.EmailDetails;

public interface EmailService {

    public String sendEmail(String to, String subject, String body);
}

