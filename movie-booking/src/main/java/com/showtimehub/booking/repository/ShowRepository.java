package com.showtimehub.booking.repository;

import com.showtimehub.booking.model.Show;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends MongoRepository<Show, ObjectId> {
    List<Show> findByMovie(ObjectId movieId);
    List<Show> findByTheatre(ObjectId theatreId);
}