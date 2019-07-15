/**
 * @Author xlyu
 * @Date 2019/7/8
 * @Description
 */
package com.itek.myoa.controller;

import com.itek.myoa.domain.ApplicationLeave;
import com.itek.myoa.domain.Approval;
import com.itek.myoa.domain.Menu;
import com.itek.myoa.domain.ZCApplication;
import com.itek.myoa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-08 21:22
 **/
@Controller
@RequestMapping("approval")
public class ApprovalController {
    @Autowired
    @Qualifier("menuService")
    private MenuService menuService;

    @Autowired
    @Qualifier("applicationLeave")
    private ApplicationLeaveService applicationLeaveService;

    @Autowired
    @Qualifier("approvalService")
    private ApprovalService approvalService;

    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;

    @Autowired
    @Qualifier("zcApplicationService")
    private ZCApplicationService zcApplicationService;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;


    @RequestMapping("index")
    public String app(String parentId, HttpSession session) {

        /**
         * 获取用户姓名
         */
        String name = (String) session.getAttribute("nameNav");
        /**
         * 获取该用户的子菜单
         */
        List<Menu> list = menuService.getSonMenuByLoginNameAndParentId(parentId, name);
        session.setAttribute("leaveApprovalList", list);
        /**
         * 获取该角色的roleId
         */
        int thisUserRoleId = roleService.getRoleIdByUserName(name);
        System.out.println(thisUserRoleId + ":thisUserRoleId");

        /**
         * 获取待审批的记录
         */
        List<ApplicationLeave> applicationLeaves = applicationLeaveService.getApplication(thisUserRoleId);
        session.setAttribute("applicationLeaves", applicationLeaves);
        return "approval/index";
    }

    @RequestMapping("leave")
    public String leaveHandle(Approval approval, RedirectAttributes attributes) {
        boolean isSuccess = approvalService.handleApprovalLeave(approval);
        if (isSuccess == true) {
            attributes.addFlashAttribute("appMsg", "审批处理成功");
            return "redirect:index?parentId=3";
        } else {
            attributes.addFlashAttribute("appMsg", "审批处理失败");
            return "redirect:index?parentId=3";
        }
    }


    @RequestMapping("detail")
    public String detail(String id, Model model) {

        Approval approval = approvalService.getApprovalById(Integer.parseInt(id));
        model.addAttribute("approval", approval);
        return "approval/detail";
    }


    @RequestMapping("zcApproval")
    public String zcApproval(HttpSession session, Model model) {
        /**
         * 获取该用户的用户id和角色id
         */
        String name = (String) session.getAttribute("nameNav");
        Integer myUserId = userService.getId(name);
        Integer myRoleId = roleService.getRoleIdByUserName(name);

        /**
         * 进入资产审批页面
         * TODO 必须和申请的角色id对等才能看到，而且申请的状态必须为0
         */
        List<ZCApplication> list = zcApplicationService.getZCApplicationShouldHandleByMe(myRoleId);
        model.addAttribute("shouldByMyHandle", list);
        return "approval/zcApproval";
    }

    @RequestMapping("approvalHistory")
    public String approvalHistory(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("nameNav");
        List<Approval> approvals = approvalService.getMyApproval(userName);
        model.addAttribute("approvals", approvals);
        return "approval/approvalHistory";
    }

    @RequestMapping("zcApprovalDetail")
    public String zcApprovalDetail(String id, Model model) {
        /**
         * 查看详细页，根据id输出查看详细的内容
         */

        ZCApplication zcApplication = zcApplicationService.getDetailInfoById(Integer.parseInt(id));
        model.addAttribute("thisDetail", zcApplication);
        return "approval/zcApprovalDetail";
    }


    @RequestMapping("handleZCApproval")
    public String handleZCApproval(Approval approval, RedirectAttributes attributes, HttpSession session) {
        approval.setId(null);
        System.out.println(approval);
        /**
         * 获取该角色的名字，查询它的角色id
         */
        String name = (String) session.getAttribute("nameNav");
        int roleId = roleService.getRoleIdByUserName(name);
        System.out.println("thisUserROLEID" + roleId);
        /**
         * 此时需要将这条审批结果插入approval表中
         */
        boolean isSuccess = approvalService.handleApprovalOfZc(approval, roleId);
        if (isSuccess == true) {
            attributes.addFlashAttribute("appMsg", "审批成功");
            return "redirect:zcApproval";
        } else {
            attributes.addFlashAttribute("appMsg", "审批失败");
            return "redirect:zcApproval";

        }

    }


    @RequestMapping("zcApprovalHistory")
    public String zcApprovalHistory(HttpSession session) {
        String name = (String) session.getAttribute("nameNav");
        String type = "资产采购审批";
        List<Approval> zcApprovals =  approvalService.getZCApprovalByName(name,type);
        session.setAttribute("zcApprovalByNameAndType",zcApprovals);
        return "approval/zcApprovalHistory";
    }

    @RequestMapping("zcHistoryDetail")
    public String zcHistoryDetail(Model model,String id){
        model.addAttribute("thisId",id);
        return "approval/zcHistoryDetail";
    }

}
