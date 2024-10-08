package com.example.tw_movie_rental.service;

import com.example.tw_movie_rental.response.OrdersResponse;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    public ResponseEntity<OrdersResponse> sendOrder(String json) throws InterruptedException;
}
