package com.example.tw_movie_rental.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.SQLException;

@Entity
public class Movie {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String name;
    @Lob
    private Blob image;
    private String dimensions;
    private String rating;
    private String Format;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "FK_Author_Movie_Id")
    private Author author;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "FK_Studio_Id")
    private Studio studio;
    private String asin;
    private String subtitles;
    private int nrOfDisks;
    private float grade=100;
    private float price;

    public Movie(String name, String dimensions, String rating, String format, Author author, Studio studio, String asin, String subtitles, int nrOfDisks, Blob image, float price) {
        this.name = name;
        this.dimensions = dimensions;
        this.rating = rating;
        Format = format;
        this.author = author;
        this.studio = studio;
        this.asin = asin;
        this.subtitles = subtitles;
        this.nrOfDisks = nrOfDisks;
        this.image=image;
        this.price=price;
    }

    public Movie() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }

    public int getNrOfDisks() {
        return nrOfDisks;
    }

    public void setNrOfDisks(int nrOfDisks) {
        this.nrOfDisks = nrOfDisks;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
    public byte[] getImage() throws SQLException {
        return image.getBytes(1, (int)image.length());
    }

    public void setImage(Blob image) {
        this.image = image;
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
