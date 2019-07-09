/**
 * @Author xlyu
 * @Date 2019/7/8
 * @Description
 */
package com.itek.myoa.controller;

import com.itek.myoa.domain.Menu;
import com.itek.myoa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private MenuService menuService;

    @RequestMapping("index")
    public String app(String parentId, Model model) {
        List<Menu> list = menuService.getSonMenu(parentId);
        model.addAttribute("list", list);
        List<Menu> list1 = menuService.getMenu();
        model.addAttribute("parentMenu", list1);
        return "application/index";
    }
}
