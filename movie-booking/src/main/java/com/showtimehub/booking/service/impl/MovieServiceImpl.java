package com.showtimehub.booking.service.impl;

import com.showtimehub.booking.model.Movie;
import com.showtimehub.booking.repository.MovieRepository;
import com.showtimehub.booking.service.MovieService;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getMoviesByCity(String cityName) {
        Aggregation aggregation = newAggregation(
            lookup("shows", "_id", "movie", "shows"),
            unwind("shows"),
            lookup("theatres", "shows.theatre", "_id", "theatres"),
            unwind("theatres"),
            lookup("cities", "theatres.city", "_id", "cities"),
            unwind("cities"),
            match(Criteria.where("cities.name").is(cityName)),
            group("_id")
                .first("title").as("title")
                .first("description").as("description")
                .first("duration").as("duration")
                .first("genre").as("genre")
        );

        logger.info("Executing aggregation query: {}", aggregation.toString());

        AggregationResults<Movie> results = mongoTemplate.aggregate(aggregation, "movies", Movie.class);
        logger.info("Aggregation query results: {}", results.getMappedResults().toString());
        return results.getMappedResults();
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