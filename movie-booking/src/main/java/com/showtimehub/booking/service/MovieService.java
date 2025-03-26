package com.showtimehub.booking.service;

import com.showtimehub.booking.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    List<Movie> getMoviesByCity(String cityName);
    Movie getMovieById(String movieId);
    Movie addMovie(Movie movie);
    void deleteMovie(String movieId);
}