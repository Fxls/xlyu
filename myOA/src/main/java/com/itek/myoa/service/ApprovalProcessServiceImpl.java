/**
 * @Author xlyu
 * @Date 2019/7/10
 * @Description
 */
package com.itek.myoa.service;

import com.itek.myoa.dao.ApprovalProcessMapper;
import com.itek.myoa.domain.ApprovalProcess;
import com.itek.myoa.domain.ApprovalProcessExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-10 14:28
 **/
@Service("ApprovalProcess")
public class ApprovalProcessServiceImpl implements ApprovalProcessService {
    @Autowired
    private ApprovalProcessMapper approvalProcessMapper;


    @Override
    public int getRoleId(String approvalName) {
        ApprovalProcessExample exam = new ApprovalProcessExample();
        exam.createCriteria().andApprovalNameEqualTo(approvalName);
        List<ApprovalProcess> list = approvalProcessMapper.selectByExample(exam);
        if (list == null || list.isEmpty()) {
            /**
             * 返回-1代表查询出错
             */
            return -1;
        } else {
            String[] idArr = list.get(0).getApprovalRoleList().split(",");
            return Integer.parseInt(idArr[0]);
        }
    }

    @Override
    public String[] getRoleList(String approvalName) {
        ApprovalProcessExample exam = new ApprovalProcessExample();
        exam.createCriteria().andApprovalNameEqualTo(approvalName);
        List<ApprovalProcess> list = approvalProcessMapper.selectByExample(exam);
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return list.get(0).getApprovalRoleList().split(",");
        }
    }
}
