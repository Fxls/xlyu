/**
 * @Author xlyu
 * @Date 2019/7/8
 * @Description
 */
package com.itek.myoa.controller;

import com.itek.myoa.domain.*;
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
 * @create: 2019-07-08 21:21
 **/
@Controller
@RequestMapping("application")
public class ApplicationController {

    @Autowired
    @Qualifier("menuService")
    private MenuService menuService;

    @Autowired
    @Qualifier("ApprovalProcess")
    private ApprovalProcessService approvalProcessService;

    @Autowired
    @Qualifier("applicationLeave")
    private ApplicationLeaveService applicationLeaveService;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("approvalService")
    private ApprovalService approvalService;

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @Autowired
    @Qualifier("zcApplicationService")
    private ZCApplicationService zcApplicationService;

    @RequestMapping("index")
    public String app(String parentId, HttpSession session) {
        String loginName = (String) session.getAttribute("nameNav");
        List<Menu> list = menuService.getSonMenuByLoginNameAndParentId(parentId, loginName);
        session.setAttribute("leavelist", list);
        return "application/index";
    }

    @RequestMapping("zcApplication")
    public String zcApplication(HttpSession session, Model model) {
        String name = (String) session.getAttribute("nameNav");
        Integer userId = userService.getId(name);
        model.addAttribute("applyerId", userId);
        return "application/zcApplication";
    }

    @RequestMapping("zcHandle")
    public String zcHandle(String applyerName,
                           String applyerId,
                           String resonShopping,
                           String proName,
                           String proNumber,
                           String proPrice,
                           String applyTime,
                           String tip,
                           RedirectAttributes attributes) {
        /**
         * 获取流程表中的第一个处理角色id
         */
        String approvalName = "资产申请";
        String[] roleIdList = approvalProcessService.getRoleList(approvalName);
        Integer approvalRoleId = Integer.valueOf(roleIdList[0]);
        ZCApplication zcApplication = new ZCApplication(null,
                Integer.parseInt(applyerId.trim()),
                applyerName.trim(),
                applyTime.trim(),
                "0",
                approvalRoleId,
                resonShopping.trim(),
                proName.trim(),
                Integer.parseInt(proNumber.trim()),
                Double.valueOf(proPrice.trim()),
                tip.trim()
        );
        System.out.println(zcApplication);

        /**
         * 通过产品表查询采购产品是否存在，存在执行插入方法，不存在返回提示信息。
         */
        boolean isHave = productService.isHaveThisProduction(zcApplication.getProName());

        if (isHave == true) {
            System.out.println("此产品存在");
            /**
             * 此时执行插入方法
             */
            boolean isSuccess = zcApplicationService.insertThisZCApplication(zcApplication);
            if (isSuccess == true) {
                attributes.addFlashAttribute("zcApplicationMsg", "资产采购申请成功");
                return "redirect:zcApplication";
            } else {
                attributes.addFlashAttribute("zcApplicationMsg", "资产采购申请失败");
                return "redirect:zcApplication";
            }
        } else {
            attributes.addFlashAttribute("zcApplicationMsg", "此产品不存在于采购表中，请联系管理员添加");
            return "redirect:zcApplication";
        }
    }


    @RequestMapping("zcHistory")
    public String zcHistory(HttpSession session, Model model) {
        /**
         * 历史纪录页
         * TODO 查询该用户的所有申请记录
         */
        String userName = (String) session.getAttribute("nameNav");
        int userId = userService.getId(userName);
        List<ZCApplication> list = zcApplicationService.getHistoryByUserId(userId);
        model.addAttribute("zcHistory", list);

        /**
         * 审批信息
         */
        List<Approval> listApproval = approvalService.getZcApprovalHandlerName(userId);
        model.addAttribute("listZcApproval", listApproval);
        return "application/zcHistory";
    }


    @RequestMapping("zcHistoryDetail")
    public String zcHistoryDetail(String id,Model model){
        ZCApplication list = zcApplicationService.getDeatilZCApplicationById(Integer.parseInt(id));
        model.addAttribute("zcHistoryDetail",list);
        return "application/zcHistoryDetail";
    }


    @RequestMapping("leave")
    public String leave(RedirectAttributes attributes,
                        String applyerName,
                        String startTime,
                        String endTime,
                        String reason) {
        /**
         * 获取申请人id
         */
        Integer applyerId = userService.getId(applyerName);

        if (applyerId == -1) {
            attributes.addFlashAttribute("appMsg", "请检查申请人姓名");
            return "redirect:index?parentId=2";
        }

        ApplicationLeave applicationLeave = new ApplicationLeave(applyerId, applyerName, startTime, endTime, reason);
        System.out.println(applicationLeave);

        /**
         * 获取该申请的审批人id
         * 通过流程表获取第一位审批人的角色id
         */
        String approvalName = "请假申请";
        int roleId = approvalProcessService.getRoleId(approvalName);

        System.out.println(roleId + "审批人id");

        if (roleId == -1) {
            System.out.println("未查询到审批人id");
            attributes.addFlashAttribute("appMsg", "申请失败");
            return "redirect:index?parentId=2";
        }
        /**
         * 插入该申请
         * 设定申请状态为0；正在审批   ，传入审批人角色id
         */
        String status = "0";
        boolean isSuccess = applicationLeaveService.insert(applicationLeave, roleId, status);
        if (isSuccess == true) {
            attributes.addFlashAttribute("appMsg", "申请成功");
            return "redirect:index?parentId=2";

        } else {
            attributes.addFlashAttribute("appMsg", "申请失败");
            return "redirect:index?parentId=2";
        }
    }


    @RequestMapping("leaveHistory")
    public String applicationHistory(HttpSession session, Model model) {
        /**
         * 获取当前用户提交的所有的申请记录
         */
        String userName = (String) session.getAttribute("nameNav");
        List<ApplicationLeave> list = applicationLeaveService.getAllApplication(userName);


        /**
         * 获取对应的处理人姓名
         */
        List<Approval> approvals = approvalService.getHandlerName();

        model.addAttribute("applicationOfLeave", list);
        model.addAttribute("approvalToLeave", approvals);

        return "application/leaveHistory";
    }
}
