package com.itek.ajax.service;

import com.itek.ajax.module.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAllAreaByCity(String citycode);
}
