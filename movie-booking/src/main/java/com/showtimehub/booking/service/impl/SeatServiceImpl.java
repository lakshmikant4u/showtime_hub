package com.showtimehub.booking.service.impl;

import com.showtimehub.booking.model.Seat;
import com.showtimehub.booking.repository.SeatRepository;
import com.showtimehub.booking.service.SeatService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<Seat> getSeatsByShow(String showId) {
        return seatRepository.findByShow(new ObjectId(showId));
    }

    @Override
    public Seat bookSeat(String seatId) {
        Seat seat = seatRepository.findById(new ObjectId(seatId)).orElseThrow();
        seat.setBooked(true);
        return seatRepository.save(seat);
    }
}