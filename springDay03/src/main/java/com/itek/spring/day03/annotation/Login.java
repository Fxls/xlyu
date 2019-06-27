/**
 * @Author xlyu
 * @Date 2019/6/27
 * @Description
 */
package com.itek.spring.day03.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: springDay03
 * @description:
 * @author: xlYu
 * @create: 2019-06-27 16:49
 **/
@Controller
@RequestMapping("/login")
public class Login {
    ModelAndView modelAndView = new ModelAndView();

    /**
     * 使用双层注解达到分层模块化效果
     */
    @RequestMapping("/login.da")
    public ModelAndView login() {

        modelAndView.addObject("login", "login");
        modelAndView.setViewName("login/login");
        return modelAndView;

    }

    @RequestMapping("/loginOut.da")
    public ModelAndView loginOut() {
        modelAndView.addObject("login", "logout");
        modelAndView.setViewName("login/login");
        return modelAndView;
    }
}
