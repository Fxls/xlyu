package com.itek.myoa.service;

import com.itek.myoa.domain.ApplicationLeave;

import java.util.List;

/**
 * @author Administrator
 */
public interface ApplicationLeaveService {

    /**
     * 插入申请
     * @param applicationLeave
     * @param approvalRoleId
     * @param status
     * @return
     */
    boolean insert(ApplicationLeave applicationLeave, int approvalRoleId, String status);

    /**
     * 查询该角色所有未处理的请假审批
     * @return
     */
    List<ApplicationLeave> getApplication(int thisUserRoleId);

    /**
     * 修改状态为1
     * @return
     */
    int setStatusTo1(Integer appicationId);

    /**
     * 更改id为下一位审批人
     * @param applicationId
     * @param newId
     * @return
     */
    int setApprovalRoleIdToNext(Integer applicationId, String newId);

    int setStatusTo2(Integer applicationId);

    List<ApplicationLeave> getAllApplication(String userName);
}
