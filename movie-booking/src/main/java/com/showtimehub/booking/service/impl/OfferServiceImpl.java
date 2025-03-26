package com.showtimehub.booking.service.impl;

import com.showtimehub.booking.model.Offer;
import com.showtimehub.booking.repository.OfferRepository;
import com.showtimehub.booking.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public List<Offer> getOffersByCity(String cityName) {
        // Implement logic to get offers by city name
        // Replace with actual implementation
        return List.of();
    }
}