/**
 * @Author xlyu
 * @Date 2019/7/12
 * @Description
 */
package com.itek.myoa.service;

import com.itek.myoa.dao.ZCApplicationMapper;
import com.itek.myoa.domain.ZCApplication;
import com.itek.myoa.domain.ZCApplicationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-12 12:09
 **/
@Service("zcApplicationService")
public class ZCApplicationServiceImpl implements ZCApplicationService {
    @Autowired
    private ZCApplicationMapper zcApplicationMapper;

    @Override
    public boolean insertThisZCApplication(ZCApplication zcApplication) {
        int count = zcApplicationMapper.insert(zcApplication);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<ZCApplication> getHistoryByUserId(int userId) {
        ZCApplicationExample exam = new ZCApplicationExample();
        exam.createCriteria().andApplyerIdEqualTo(userId);
        List<ZCApplication> list = zcApplicationMapper.selectByExample(exam);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public ZCApplication getDeatilZCApplicationById(int parseInt) {
        ZCApplication application = zcApplicationMapper.selectByPrimaryKey(parseInt);
        return application;
    }

    @Override
    public List<ZCApplication> getZCApplicationShouldHandleByMe(Integer myRoleId) {
        /**
         * 查询所有approval——list-role为myRoleId且status=0的记录
         */
        ZCApplicationExample exam = new ZCApplicationExample();
        exam.createCriteria().andApprovalRoleIdEqualTo(myRoleId).andStatusEqualTo("0");
        List<ZCApplication> list = zcApplicationMapper.selectByExample(exam);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public ZCApplication getDetailInfoById(int parseInt) {
        ZCApplication zcApplication = zcApplicationMapper.selectByPrimaryKey(parseInt);
        return zcApplication;
    }

    @Override
    public int changeStatusTo1ById(Integer applicationId) {
        int count = zcApplicationMapper.updateById(applicationId);
        if (count > 0){
            return count;
        }
        return -1;
    }

    @Override
    public int changeStatusTo2ById(Integer applicationId) {
        int count = zcApplicationMapper.updateById2(applicationId);
        if (count > 0){
            return count;
        }
        return -1;
    }

    @Override
    public int setNewRoleIdByApplicationIdForZc(int newRoleId, Integer applicationId) {
        Map<String,Object> map = new HashMap<>();
        map.put("setId",newRoleId);
        map.put("id",applicationId);
        int count =  zcApplicationMapper.updateNewRoleIdByApplicationIdAndNewRoleId(map);
        if (count > 0){
            return count;
        }
        return -1;
    }
}
