/**
 * @Author xlyu
 * @Date 2019/6/29
 * @Description
 */
package com.itek.spring.springDay04.controller;

import com.itek.spring.springDay04.commons.CheckResult;
import com.itek.spring.springDay04.commons.ResultEnum;
import com.itek.spring.springDay04.domain.User;
import com.itek.spring.springDay04.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @program: springDay04
 * @description:
 * @author: xlYu
 * @create: 2019-06-29 14:00
 **/
@Controller
public class LoginController {

    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

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
    public String checkUser(User user, HttpSession session, Model model) {
        CheckResult<User> result = loginService.checkUser(user);
        if ((int) result.getResultCode() == ResultEnum.SUCCESS.getResultCode()) {
            /**
             * 登录成功，重定向跳转页面
             */
            session.setAttribute("user", result.getData());
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
