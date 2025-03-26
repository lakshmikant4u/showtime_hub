package com.showtimehub.booking.service.impl;

import com.showtimehub.booking.model.Movie;
import com.showtimehub.booking.repository.MovieRepository;
import com.showtimehub.booking.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getMoviesByCity(String cityName) {
        // Implement aggregation query to get movies by city name
        // Replace with actual implementation
        return List.of();
    }

    @Override
    public Movie getMovieById(String movieId) {
        return movieRepository.findById(new ObjectId(movieId)).orElse(null);
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(String movieId) {
        movieRepository.deleteById(new ObjectId(movieId));
    }
}