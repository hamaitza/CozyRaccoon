package com.example.tw_movie_rental.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.SQLException;

@Entity
public class Comic {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "FK_Author_Id")
    private Author author;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "FK_Publisher_Id")
    private Publisher publisher;
    private String name;
    @Lob
    private Blob image;
    private int quantity;
    private String disponibility;
    private Float price;
    private String sku;
    private String description;
    private String format;
    private String publishedDate;
    private String size;
    private String genre;

    public Comic(Author author, Publisher publisher, String name, int quantity, String disponibility, Float price, String sku, String description, String format, String publishedDate, String size, String genre,Blob image ) {
        this.author = author;
        this.publisher = publisher;
        this.name = name;
        this.quantity = quantity;
        this.disponibility = disponibility;
        this.price = price;
        this.sku = sku;
        this.description = description;
        this.format = format;
        this.publishedDate = publishedDate;
        this.size = size;
        this.genre = genre;
        this.image=image;
    }

    public Comic() {

    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDisponibility() {
        return disponibility;
    }

    public void setDisponibility(String disponibility) {
        this.disponibility = disponibility;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() throws SQLException {
        return image.getBytes(1, (int)image.length());
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
