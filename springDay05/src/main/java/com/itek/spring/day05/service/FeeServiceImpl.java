/**
 * @Author xlyu
 * @Date 2019/7/1
 * @Description
 */
package com.itek.spring.day05.service;

import com.itek.spring.day05.dao.FeeInter;
import com.itek.spring.day05.domain.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springDay05
 * @description:
 * @author: xlYu
 * @create: 2019-07-01 16:30
 **/
@Service("feeService")
public class FeeServiceImpl implements FeeService {

    @Autowired
    @Qualifier("feeImpl")
    private FeeInter feeInter;

    @Override
    public List<Fee> getFeeInfo() {
        return feeInter.selectFee();
    }

    @Override
    public List<Fee> sortForBaseCost(String sortType) {
        return feeInter.selectFeeOrderByCost(sortType);
    }

    @Override
    public List<Fee> sortForBaseTime(String sortType) {
        return feeInter.selectFeeOrderByTime(sortType);
    }
}
