package com.showtimehub.booking.service.impl;

import com.showtimehub.booking.model.Booking;
import com.showtimehub.booking.repository.BookingRepository;
import com.showtimehub.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking bookTicket(Booking booking) {
        return bookingRepository.save(booking);
    }
}