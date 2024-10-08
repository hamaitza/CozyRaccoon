package com.example.tw_movie_rental;

import java.io.ByteArrayOutputStream;
import java.util.*;

import com.example.tw_movie_rental.Model.*;
import com.example.tw_movie_rental.repository.ComicRepository;
import com.example.tw_movie_rental.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@ComponentScan
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("com.example.tw_movie_rental.repository")
public class TwMovieRentalApplication implements CommandLineRunner {
    @Autowired
    private ComicRepository comicRepository;
    @Autowired
    private MovieRepository movieRepository;

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.getData("aasa","dasdas", new LinkedHashMap<>(), "asdas");
        invoice.writeInvoice();

        SpringApplication.run(TwMovieRentalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
