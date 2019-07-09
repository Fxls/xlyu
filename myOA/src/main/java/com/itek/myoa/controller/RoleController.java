/**
 * @Author xlyu
 * @Date 2019/7/8
 * @Description
 */
package com.itek.myoa.controller;

import com.itek.myoa.domain.Menu;
import com.itek.myoa.domain.Role;
import com.itek.myoa.service.MenuService;
import com.itek.myoa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-08 14:51
 **/
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;

    @Autowired
    @Qualifier("menuService")
    private MenuService menuService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String usrAdd(Model model) {
        List<Menu> list = menuService.getMenu();
        model.addAttribute("parentMenu",list);
        return "role/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String userAdd(Role role, Model model) {
        String msg = roleService.insertRole(role);
        model.addAttribute("msg",msg);
        return "role/add";
    }
}
