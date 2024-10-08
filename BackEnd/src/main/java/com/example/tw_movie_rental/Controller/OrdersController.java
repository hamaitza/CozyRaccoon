package com.example.tw_movie_rental.Controller;

import com.example.tw_movie_rental.service.EmailService;
import com.example.tw_movie_rental.service.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 92000, allowCredentials = "false")
public class OrdersController {
    final
    OrderService orderService;

    public OrdersController( OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/generateBill")
    @CrossOrigin(origins = "http://localhost:3000")
    public void generateBill(@RequestBody String json) throws InterruptedException {
        orderService.sendOrder(json);
    }
}
