/**
 * @Author xlyu
 * @Date 2019/7/10
 * @Description
 */
package com.itek.myoa.service;

import com.itek.myoa.dao.ApplicationLeaveMapper;
import com.itek.myoa.domain.ApplicationLeave;
import com.itek.myoa.domain.ApplicationLeaveExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-10 14:41
 **/
@Service("applicationLeave")
public class ApplicationLeaveServiceImpl implements ApplicationLeaveService {
    @Autowired
    private ApplicationLeaveMapper applicationLeaveMapper;


    @Override
    public boolean insert(ApplicationLeave applicationLeave, int approvalRoleId, String status) {
        applicationLeave.setApprovalRoleId(String.valueOf(approvalRoleId));
        applicationLeave.setStatus(status);
        int count = applicationLeaveMapper.insert(applicationLeave);
        if (count > 0) {
            return true;
        }
        return false;
        /**
         * TODO 申请创建时间
         */
    }

    @Override
    public List<ApplicationLeave> getApplication() {
        ApplicationLeaveExample exam = new ApplicationLeaveExample();
        /**
         * 查询还没有被审批的申请
         */
        exam.createCriteria().andStatusEqualTo("0");
        List<ApplicationLeave> list = applicationLeaveMapper.selectByExample(exam);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public int setStatusTo1(Integer applicationId) {

        int count = applicationLeaveMapper.updateStatus(applicationId);
        if (count > 0) {
            return count;
        }
        return 0;
    }

    @Override
    public int setApprovalRoleIdToNext(Integer applicationId, String newId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", applicationId);
        map.put("approvalRoleId", newId);
        int count = applicationLeaveMapper.updateApprovalRoleIdByapplicationId(map);
        if (count > 0) {
            return count;
        }
        return 0;
    }

    @Override
    public int setStatusTo2(Integer applicationId) {
        int count = applicationLeaveMapper.updateStatus2(applicationId);
        if (count > 0) {
            return count;
        }
        return 0;

    }
}
