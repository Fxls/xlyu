/**
 * @Author xlyu
 * @Date 2019/7/10
 * @Description
 */
package com.itek.myoa.service;

import com.itek.myoa.dao.ApprovalMapper;
import com.itek.myoa.domain.Approval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-10 18:27
 **/
@Service("approvalService")
public class ApprovalServiceImpl implements ApprovalService {
    @Autowired
    private ApprovalMapper approvalMapper;

    @Autowired
    @Qualifier("ApprovalProcess")
    private ApprovalProcessService approvalProcessService;

    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;

    @Autowired
    @Qualifier("applicationLeave")
    private ApplicationLeaveService applicationLeaveService;

    @Override
    public boolean handleApprovalLeave(Approval approval) {
        int count = approvalMapper.insertSelective(approval);
        String yes = "通过";
        String no = "不通过";
        if (count > 0) {
            /**
             * 判断result是通过还是不通过
             */
            if (approval.getResult().equals(yes)) {
                /**
                 * 审批通过，交于下一位审批人审批，如果自己为最后一位审批人
                 * 修改申请状态
                 */
                String approvalName = "请假申请";
                String[] roleList = approvalProcessService.getRoleList(approvalName);
                /**
                 * 获取该用户的角色id
                 */
                int roleId = roleService.getRoleIdByTables(approval.getApplicationId());

                /**
                 /**
                 * 如果该用户的角色id是最后一位，修改状态
                 */
                if (roleId == Integer.parseInt(roleList[roleList.length - 1])) {
                    /**
                     * 修改状态
                     */
                    int success = applicationLeaveService.setStatusTo1(approval.getApplicationId());
                    if (success > 0) {
                        System.out.println("申请状态修改成功");
                    }
                } else {
                    for (int index = 0; index < roleList.length; index++) {
                        /**
                         * 查看审批人的role_id的index
                         */
                        if (roleId == Integer.parseInt(roleList[index])) {
                            /**
                             * 修改approval——role——id为index+1
                             */
                            int count2 = applicationLeaveService.setApprovalRoleIdToNext(approval.getApplicationId(), roleList[index+1]);
                            if (count2 > 0) {
                                System.out.println("提交下一位审批人成功");
                            }
                        }

                    }
                }
            } else if (approval.getResult().equals(no)) {
                /**
                 * 审批不通过，直接修改申请状态
                 */
                int count3 = applicationLeaveService.setStatusTo2(approval.getApplicationId());
                if (count3 > 0) {
                    System.out.println("不通过状态下的修改状态成功");
                }
            } else {
                /**
                 * result，联系管理员处理
                 */
                System.out.println("result异常，请联系管理员");
            }
            return true;
        } else {
            return false;
        }

    }
}
