package com.showtimehub.booking.service.impl;

import com.showtimehub.booking.model.Show;
import com.showtimehub.booking.repository.ShowRepository;
import com.showtimehub.booking.service.ShowService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Override
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    @Override
    public List<Show> getShowsByMovie(String movieId) {
        return showRepository.findByMovie(new ObjectId(movieId));
    }

    @Override
    public List<Show> getShowsByTheater(String theaterId) {
        return showRepository.findByTheatre(new ObjectId(theaterId));
    }
}