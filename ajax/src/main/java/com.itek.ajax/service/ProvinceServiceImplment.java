/**
 * @Author xlyu
 * @Date 2019/6/13
 * @Description
 */
package com.itek.ajax.service;

import com.itek.ajax.dao.ProvinceImpl;
import com.itek.ajax.dao.ProvinceInter;
import com.itek.ajax.module.Province;

import java.util.List;

/**
 * @program: ajax
 * @description:
 * @author: xlyu
 * @create: 2019-06-13 19:55
 **/
public class ProvinceServiceImplment implements ProvinceService {
    private ProvinceInter pro = new ProvinceImpl();
    @Override
    public List<Province> getAllProvince() {
        return pro.selectProvince();
    }
}
