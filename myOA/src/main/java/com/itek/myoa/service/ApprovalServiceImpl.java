/**
 * @Author xlyu
 * @Date 2019/7/10
 * @Description
 */
package com.itek.myoa.service;

import com.itek.myoa.dao.ApprovalMapper;
import com.itek.myoa.domain.Approval;
import com.itek.myoa.domain.ApprovalExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    @Qualifier("zcApplicationService")
    private ZCApplicationService zcApplicationService;

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
                int roleId = roleService.getRoleIdByUserName(approval.getHandleName());

                System.out.println(roleId + "**************");

                /**
                 /**
                 * 如果该用户的角色id是最后一位，修改状态
                 */
                if (roleId == Integer.parseInt(roleList[roleList.length - 1])) {
                    System.out.println("我是最后一个审批人*******");
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
                            int count2 = applicationLeaveService.setApprovalRoleIdToNext(approval.getApplicationId(), roleList[index + 1]);
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

    @Override
    public List<Approval> getHandlerName() {
        List<Approval> list = approvalMapper.selectByTables();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Approval> getMyApproval(String userName) {
        ApprovalExample exam = new ApprovalExample();
        exam.createCriteria().andHandleNameEqualTo(userName);
        List<Approval> list = approvalMapper.selectByExample(exam);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public Approval getApprovalById(int parseInt) {
        Approval approval = approvalMapper.selectByPrimaryKey(parseInt);
        if (approval == null) {
            return null;
        }
        return approval;
    }

    @Override
    public List<Approval> getZcApprovalHandlerName(Integer userId) {
        List<Approval> list = approvalMapper.getZcApproval(userId);
        if (list == null || list.isEmpty()) {
            return null;
        }

        return list;
    }

    @Override
    public boolean handleApprovalOfZc(Approval approval, Integer thisUserRoleId) {
        /**
         * 执行插入方法，插入approval中
         */

        int count = approvalMapper.insert(approval);
        if (count > 0) {
            /**
             * 插入成功
             */
            System.out.println("插入记录成功");
            /**
             * 此时需要对该用户的角色进行判断，判断该角色是否处于流程中的最后一名角色
             */
            String[] strArr = approvalProcessService.getRoleList("资产申请");
            String yes = "通过";
            String no = "不通过";
            /**
             * 如果是，则需要修改申请记录的状态
             */
            if (thisUserRoleId == Integer.parseInt(strArr[strArr.length - 1])) {

                if (approval.getResult().equals(yes)) {
                    /**
                     * 如果同意，修改状态为1
                     */
                    int col = zcApplicationService.changeStatusTo1ById(approval.getApplicationId());
                    if (col > 0) {
                        System.out.println("最后一位执行人修改状态成功1");
                    } else {
                        System.out.println("最后一位执行人修改状态失败1");
                    }
                } else if (approval.getResult().equals(no)) {
                    /**
                     * 如果不同意，修改状态为2
                     */
                    int col2 = zcApplicationService.changeStatusTo2ById(approval.getApplicationId());
                    if (col2 > 0) {
                        System.out.println("最后一位执行人修改状态成功2");
                    } else {
                        System.out.println("最后一位执行人修改状态失败2");
                    }
                } else {
                    System.out.println("位置result，联系管理员");
                }

            } else {
                /**
                 * 不是最后一位审批人,更改申请记录的roleId交付于下一位审批人
                 */
                if (approval.getResult().equals(yes)) {
                    for (int i = 0; i < strArr.length; i++) {
                        if (Integer.parseInt(strArr[i]) == thisUserRoleId) {
                            int newRoleId = Integer.parseInt(strArr[i + 1]);
                            int col = zcApplicationService.setNewRoleIdByApplicationIdForZc(newRoleId, approval.getApplicationId());
                            if (col > 0) {
                                System.out.println("交于下一位审批人成功");
                            } else {
                                System.out.println("交于下一位审批人失败");
                            }
                        }
                    }
                } else if (approval.getResult().equals(no)) {
                    /**
                     * 如果不让通过直接修改状态
                     */
                    int col = zcApplicationService.changeStatusTo2ById(approval.getApplicationId());
                    if (col > 0) {
                        System.out.println("中间人不通过成功");
                    } else {
                        System.out.println("中间人不通过失败");
                    }
                }
            }
            return true;
        } else {
            /**
             * 插入失败
             */
            System.out.println("插入失败！");
            return false;
        }
    }

    @Override
    public List<Approval> getZCApprovalByName(String name, String type) {
        ApprovalExample exam = new ApprovalExample();
        exam.createCriteria().andHandleNameEqualTo(name).andApprovalTypeEqualTo(type);
        List<Approval> approvals = approvalMapper.selectByExample(exam);
        if (approvals == null || approvals.isEmpty()){
            return null;
        }
        return approvals;
    }
}
