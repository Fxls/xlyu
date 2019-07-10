/**
 * @Author xlyu
 * @Date 2019/7/8
 * @Description
 */
package com.itek.myoa.controller;

import com.itek.myoa.domain.ApplicationLeave;
import com.itek.myoa.domain.Menu;
import com.itek.myoa.service.ApplicationLeaveService;
import com.itek.myoa.service.ApprovalProcessService;
import com.itek.myoa.service.MenuService;
import com.itek.myoa.service.UserService;
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

    @RequestMapping("index")
    public String app(String parentId, Model model, HttpSession session) {
//        List<Menu> list = menuService.getSonMenu(parentId);
//        model.addAttribute("list", list);
        String loginName = (String) session.getAttribute("nameNav");
        List<Menu> list = menuService.getSonMenuByLoginNameAndParentId(parentId, loginName);
        model.addAttribute("list", list);


        return "application/index";
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
}
