package com.example.tw_movie_rental.repository;

import com.example.tw_movie_rental.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Object> {
}
