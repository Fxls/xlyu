/**
 * @Author xlyu
 * @Date 2019/7/1
 * @Description
 */
package com.itek.spring.day05.controller;

import com.itek.spring.day05.commons.CheckResult;
import com.itek.spring.day05.commons.ResultEnum;
import com.itek.spring.day05.domain.User;
import com.itek.spring.day05.service.LoginService;
import com.itek.spring.day05.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: springDay05
 * @description:
 * @author: xlYu
 * @create: 2019-07-01 14:19
 **/
@Controller
public class LoginController {
    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    @Autowired
    @Qualifier("menu")
    private MenuService menuService;

    /**
     * 使用字符串直接进行参数处理的方法
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    /**
     * 用户登录校验
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String checkUser(User user, HttpSession session, Model model, HttpServletRequest req) {
        /**
         * 获取用户输入的验证码用于校验
         */
        String capInput = req.getParameter("cap");
        CheckResult<User> result = loginService.checkUser(user, req, capInput);

        if ((int) result.getResultCode() == ResultEnum.SUCCESS.getResultCode()) {
            /**
             * 登录成功，重定向跳转页面
             */
            session.setAttribute("user", result.getData());
            session.setAttribute("menus", menuService.selectMenusByUserId(result.getData().getId()));
            return "redirect:/index.do";
        } else {
            /**
             * 登录失败，给用户返回错误信息
             */
            model.addAttribute("msg", result.getMessage());
            return "login";
        }
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }
}
