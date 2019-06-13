/**
 * @Author xlyu
 * @Date 2019/6/13
 * @Description
 */
package com.itek.ajax.service;

import com.itek.ajax.dao.AreaImpl;
import com.itek.ajax.dao.AreaInter;
import com.itek.ajax.module.Area;

import java.util.List;

/**
 * @program: ajax
 * @description:
 * @author: xlyu
 * @create: 2019-06-13 22:57
 **/
public class AreaServiceImplent implements AreaService {
    private AreaInter areaInter = new AreaImpl();

    @Override
    public List<Area> getAllAreaByCity(String citycode) {
        return areaInter.selectAllAreaByCityCode(citycode);
    }
}
