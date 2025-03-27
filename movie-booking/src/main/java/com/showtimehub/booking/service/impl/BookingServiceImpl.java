package com.showtimehub.booking.service.impl;

import com.showtimehub.booking.exception.SeatAlreadyBookedException;
import com.showtimehub.booking.model.Booking;
import com.showtimehub.booking.model.Seat;
import com.showtimehub.booking.repository.BookingRepository;
import com.showtimehub.booking.repository.SeatRepository;
import com.showtimehub.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SeatRepository seatRepository;

    private final Lock lock = new ReentrantLock();
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public Booking bookTicket(Booking booking) {
        Future<Booking> futureBooking = executorService.submit(new Callable<Booking>() {
            @Override
            public Booking call() throws Exception {
                while (true) {
                    lock.lock();
                    try {
                        // Check if the seats are available
                        List<Seat> seats = seatRepository.findAllById(booking.getSeats());
                        for (Seat seat : seats) {
                            if (seat.isBooked()) {
                                throw new SeatAlreadyBookedException("Seat " + seat.getId() + " is already booked.");
                            }
                        }

                        // Mark seats as booked
                        for (Seat seat : seats) {
                            seat.setBooked(true);
                            seatRepository.save(seat);
                        }

                        // Save the booking
                        return bookingRepository.save(booking);
                    } catch (OptimisticLockingFailureException e) {
                        // Retry booking in case of optimistic locking failure
                        System.out.println("Optimistic locking failure, retrying booking...");
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        try {
            return futureBooking.get();
        } catch (Exception e) {
            throw new RuntimeException("Failed to book ticket", e);
        }
    }
}