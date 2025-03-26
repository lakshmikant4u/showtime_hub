package com.showtimehub.booking.service;

import com.showtimehub.booking.model.Theater;

import java.util.List;

public interface TheaterService {
    List<Theater> getAllTheaters();
    List<Theater> getTheatersByCity(String cityName);
    List<Theater> getTheatersByMovieInCity(String movieTitle, String cityName);
}