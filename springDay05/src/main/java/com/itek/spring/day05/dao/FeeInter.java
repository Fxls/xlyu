package com.itek.spring.day05.dao;

import com.itek.spring.day05.domain.Fee;

import java.util.List;

/**
 * @author xlYu
 */
public interface FeeInter {
    /**
     * 资费查询
     * @return
     */
    List<Fee> selectFee();

    /**
     * 基费排序
     * @param sortType
     * @return
     */
    List<Fee> selectFeeOrderByCost(String sortType);

    /**
     * 时长排序
     * @param sortType
     * @return
     */
    List<Fee> selectFeeOrderByTime(String sortType);
}
