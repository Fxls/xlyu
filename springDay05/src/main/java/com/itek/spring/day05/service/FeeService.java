package com.itek.spring.day05.service;

import com.itek.spring.day05.domain.Fee;

import java.util.List;

/**
 * @author xlYu
 */
public interface FeeService {

    /**
     * 资费查询
     * @return
     */
    List<Fee> getFeeInfo();

    /**
     * 基费排序
     * @param sortType
     * @return
     */
    List<Fee> sortForBaseCost(String sortType);

    /**
     * 时长排序
     * @param sortType
     * @return
     */
    List<Fee> sortForBaseTime(String sortType);
}
