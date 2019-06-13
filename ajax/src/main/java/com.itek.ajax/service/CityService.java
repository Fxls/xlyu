package com.itek.ajax.service;

import com.itek.ajax.module.City;

import java.util.List;

public interface CityService {

    List<City> getAllCityByProvince(String provincecode);
}
