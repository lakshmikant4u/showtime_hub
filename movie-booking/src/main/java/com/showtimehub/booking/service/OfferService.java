package com.showtimehub.booking.service;

import com.showtimehub.booking.model.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> getAllOffers();
    List<Offer> getOffersByCity(String cityName);
}