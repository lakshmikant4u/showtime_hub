package com.showtimehub.booking.service;

import com.showtimehub.booking.model.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getSeatsByShow(String showId);
    Seat bookSeat(String seatId);
}