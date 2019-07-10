/**
 * @Author xlyu
 * @Date 2019/7/9
 * @Description
 */
package com.itek.myoa.controller;

import com.itek.myoa.domain.Menu;
import com.itek.myoa.domain.User;
import com.itek.myoa.service.LoginService;
import com.itek.myoa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-09 08:43
 **/
@Controller
public class LoginController {
    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    @Autowired
    @Qualifier("menuService")
    private MenuService menuService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session) {
        List<User> list = loginService.checkUser(user);

        if (list != null) {
            User user2 = list.get(0);
            String name = user2.getName();
            session.setAttribute("nameNav",name);


            /**
             * 登录成功查询角色的所有权限包括顶级菜单以及子菜单
             */
            List<Menu> menuList = menuService.getTopMenuByLoginName(user.getLoginName());
            session.setAttribute("topMenus",menuList);
            return "index";
        } else {
            model.addAttribute("loginMsg", "登录失败");
            return "login";
        }

    }

}
