package com.showtimehub.booking.repository;

import com.showtimehub.booking.model.Movie;
import java.util.List;

public interface StaticMovieRepository {
    List<Movie> findAll();
    List<Movie> findByCity(String city);
    void save(Movie movie);
	List<Movie> findByTitle(String title);
}