package com.showtimehub.booking.repository;

import com.showtimehub.booking.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    
    @Query("{ 'shows.theatre.city': ?0 }")
    List<Movie> findMoviesByCityName(String cityName);
}