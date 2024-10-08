package com.example.tw_movie_rental.repository;

import com.example.tw_movie_rental.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Object> {
}
