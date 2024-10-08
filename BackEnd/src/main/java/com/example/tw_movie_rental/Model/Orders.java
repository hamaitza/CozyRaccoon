package com.example.tw_movie_rental.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_Customer_Id")
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_CartMovie_Id")
    private List<Movie>  cartMovie = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ComicMovie_Id")
    private List<Comic>  cartComic = new ArrayList<>();
    private Float price;

    public Orders(Customer customer, List<Movie> cartMovie, List<Comic> cartComic) {
        this.customer = customer;
        this.cartMovie = cartMovie;
        this.cartComic = cartComic;
    }

    public Orders() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<Movie> getCartMovie() {
        return cartMovie;
    }

    public void setCartMovie(List<Movie> cartMovie) {
        this.cartMovie = cartMovie;
    }

    public List<Comic> getCartComic() {
        return cartComic;
    }

    public void setCartComic(List<Comic> cartComic) {
        this.cartComic = cartComic;
    }
}
