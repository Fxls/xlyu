package com.itek.ajax.dao;

import com.itek.ajax.module.City;

import java.util.List;

public interface CityInter {
    List<City> selectAllCityByProvince(String provincecode);
}
