package com.itek.myoa.service;

import com.itek.myoa.domain.Approval;

import java.util.List;

/**
 * @author xlyu
 */
public interface ApprovalService {

    /**
     * 审批处理
     * @param approval
     * @return
     */
    boolean handleApprovalLeave(Approval approval);

    List<Approval> getHandlerName();

    List<Approval> getMyApproval(String userName);

    Approval getApprovalById(int parseInt);

    List<Approval> getZcApprovalHandlerName(Integer userId);


    boolean handleApprovalOfZc(Approval approval,Integer thisUseRoleId);

    List<Approval> getZCApprovalByName(String name, String type);
}
