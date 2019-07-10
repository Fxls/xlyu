package com.itek.myoa.service;

/**
 * @author xlyu
 */
public interface ApprovalProcessService {

    /**
     * 获取流程表中id
     *
     * @param approvalName
     * @return
     */
    int getRoleId(String approvalName);

    /**
     * 获取审批流程
     * @param approvalName
     * @return
     */
    String[] getRoleList(String approvalName);
}
