package com.showtimehub.booking.controller;

import com.showtimehub.booking.exception.SeatAlreadyBookedException;
import com.showtimehub.booking.model.Booking;
import com.showtimehub.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.showtimehub.booking.model.*;
import com.showtimehub.booking.service.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private CityService cityService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private ShowService showService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private OfferService offerService;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/movies")
    public List<Movie> getAllMoviesInCity(@RequestParam String city) {
        return movieService.getMoviesByCity(city);
    }

    @GetMapping("/theaters")
    public List<Theater> getAllTheatersWithShow(@RequestParam String movieId, @RequestParam String cityName) {
        return theaterService.getTheatersByMovieInCity(movieId, cityName);
    }

    @GetMapping("/shows")
    public List<Show> getShowsByMovie(@RequestParam String movieId) {
        return showService.getShowsByMovie(movieId);
    }

    @GetMapping("/seats")
    public List<Seat> getSeatsByShow(@RequestParam String showId) {
        return seatService.getSeatsByShow(showId);
    }

    @PostMapping("/book")
    public ResponseEntity<?> bookTicket(@RequestBody Booking booking) {
        try {
            Booking savedBooking = bookingService.bookTicket(booking);
            return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
        } catch (SeatAlreadyBookedException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to book ticket", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/offers")
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }
}