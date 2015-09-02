package com.hj.restdemo.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by heiko on 02.09.15.
 */
@Component
public class Init {


    @Autowired
    CountryRepository repository;


    @Autowired
    LocationRepository locationRepository;

    @PostConstruct
    public void init() {

        repository.save(new Country("DE", "Deutschland"));
        repository.save(new Country("US", "United States of AMerica"));
        repository.save(new Country("FR", "France"));
        repository.save(new Country("GB", "United Kingdom"));


        locationRepository.save(new Location("DEHAM","Hamburg"));
        locationRepository.save(new Location("DEBRE","Bremen"));
        locationRepository.save(new Location("GBLON","London"));



    }


}
