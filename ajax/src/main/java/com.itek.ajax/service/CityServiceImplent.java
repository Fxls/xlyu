/**
 * @Author xlyu
 * @Date 2019/6/13
 * @Description
 */
package com.itek.ajax.service;

import com.itek.ajax.dao.CityImp;
import com.itek.ajax.dao.CityInter;
import com.itek.ajax.module.City;

import java.util.List;

/**
 * @program: ajax
 * @description:
 * @author: xlyu
 * @create: 2019-06-13 22:00
 **/
public class CityServiceImplent implements CityService {
    private CityInter cityInter = new CityImp();
    @Override
    public List<City> getAllCityByProvince(String provincecode) {
        return cityInter.selectAllCityByProvince(provincecode);
    }
}
