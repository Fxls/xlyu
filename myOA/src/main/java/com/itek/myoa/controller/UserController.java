/**
 * @Author xlyu
 * @Date 2019/7/8
 * @Description
 */
package com.itek.myoa.controller;

import com.itek.myoa.domain.Menu;
import com.itek.myoa.domain.User;
import com.itek.myoa.service.MenuService;
import com.itek.myoa.service.UserService;
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
@RequestMapping("user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("menuService")
    private MenuService menuService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String usrAdd(Model model) {
        List<Menu> list = menuService.getMenu();
        model.addAttribute("parentMenu",list);
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String userAdd(User user, Model model) {
        String msg = userService.insertUser(user);
        model.addAttribute("msg",msg);
        return "user/add";
    }
}
