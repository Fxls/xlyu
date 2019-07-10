package com.itek.myoa.service;

import com.itek.myoa.domain.Approval;

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
}
