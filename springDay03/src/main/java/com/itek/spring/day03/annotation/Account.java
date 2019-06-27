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
 * @create: 2019-06-27 17:01
 **/
@Controller
@RequestMapping("/account")
public class Account {
    @RequestMapping("/account.da")
    public ModelAndView account() {

       ModelAndView modelAndView = new ModelAndView("account/account");
       modelAndView.addObject("account","account");
        return modelAndView;
    }
}
