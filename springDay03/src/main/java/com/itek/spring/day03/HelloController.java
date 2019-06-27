/**
 * @Author xlyu
 * @Date 2019/6/27
 * @Description
 */
package com.itek.spring.day03;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springDay03
 * @description: 实现Controller接口（import org.springframework.web.servlet.mvc.Controller）
 * @author: xlYu
 * @create: 2019-06-27 10:36
 **/
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, Object> params = new HashMap<>();
        /**
         * 返回一个ModelAndView对象
         */
        System.out.println("Hello World");
        ModelAndView mav = new ModelAndView();
        /**
         * 设置视图名
         * viewResolver接收到mav对象。获取视图名称
         * prefix+viewName+suffix：定位转发的试图jsp页面
         */

        mav.setViewName("hello");
        /**
         * 绑定数据
         */
        mav.addObject("name", "xlyu");
        mav.addObject("age", 18);
        return mav;
    }
}
