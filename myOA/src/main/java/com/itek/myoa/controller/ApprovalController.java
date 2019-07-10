/**
 * @Author xlyu
 * @Date 2019/7/8
 * @Description
 */
package com.itek.myoa.controller;

import com.itek.myoa.domain.ApplicationLeave;
import com.itek.myoa.domain.Approval;
import com.itek.myoa.domain.Menu;
import com.itek.myoa.service.ApplicationLeaveService;
import com.itek.myoa.service.ApprovalService;
import com.itek.myoa.service.MenuService;
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


    @RequestMapping("index")
    public String app(String parentId, Model model, HttpSession session) {

        String name = (String) session.getAttribute("nameNav");
        System.out.println(name);
        List<Menu> list = menuService.getSonMenuByLoginNameAndParentId(parentId, name);
        System.out.println(list);
        model.addAttribute("list", list);
//        List<Menu> list = menuService.getSonMenu(parentId);
//        model.addAttribute("list", list);
        List<ApplicationLeave> applicationLeaves = applicationLeaveService.getApplication();
        model.addAttribute("applicationLeaves", applicationLeaves);
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

}
