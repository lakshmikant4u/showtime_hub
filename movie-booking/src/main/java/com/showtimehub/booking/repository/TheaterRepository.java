package com.showtimehub.booking.repository;

import com.showtimehub.booking.model.Theater;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends MongoRepository<Theater, ObjectId> {
    List<Theater> findByCity(ObjectId cityId);
    List<Theater> findByShowsContaining(ObjectId showId);
}