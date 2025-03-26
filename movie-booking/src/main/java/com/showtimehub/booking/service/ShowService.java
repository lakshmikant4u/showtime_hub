package com.showtimehub.booking.service;

import com.showtimehub.booking.model.Show;

import java.util.List;

public interface ShowService {
    List<Show> getAllShows();
    List<Show> getShowsByMovie(String movieId);
    List<Show> getShowsByTheater(String theaterId);
}