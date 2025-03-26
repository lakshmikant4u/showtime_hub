package com.showtimehub.booking.controller;

import com.showtimehub.booking.model.*;
import com.showtimehub.booking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Booking bookTicket(@RequestBody Booking booking) {
        return bookingService.bookTicket(booking);
    }

    @GetMapping("/offers")
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }
}