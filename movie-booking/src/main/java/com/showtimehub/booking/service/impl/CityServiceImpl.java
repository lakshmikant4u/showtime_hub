package com.showtimehub.booking.service.impl;

import com.showtimehub.booking.model.City;
import com.showtimehub.booking.repository.CityRepository;
import com.showtimehub.booking.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}