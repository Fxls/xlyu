package com.itek.ajax.dao;

import com.itek.ajax.module.Area;

import java.util.List;

public interface AreaInter {
    List<Area> selectAllAreaByCityCode(String citycode);
}
