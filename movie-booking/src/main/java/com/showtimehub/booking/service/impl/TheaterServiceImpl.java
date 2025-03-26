package com.showtimehub.booking.service.impl;

import com.showtimehub.booking.model.Theater;
import com.showtimehub.booking.repository.TheaterRepository;
import com.showtimehub.booking.service.TheaterService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    @Override
    public List<Theater> getTheatersByCity(String cityName) {
        // Implement logic to get theaters by city name
        // Replace with actual implementation
        return List.of();
    }

    @Override
    public List<Theater> getTheatersByMovieInCity(String movieTitle, String cityName) {
        // Implement logic to fetch theaters by movie title and city name
        // Replace with actual implementation
        return List.of();
    }
}