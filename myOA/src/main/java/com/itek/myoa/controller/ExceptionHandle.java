/**
 * @Author xlyu
 * @Date 2019/7/8
 * @Description
 */
package com.itek.myoa.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-08 16:15
 **/
@ControllerAdvice
public class ExceptionHandle {
//    @ExceptionHandler(value = Exception.class)
//
//    public String exceptionHandle(Exception e, HttpServletRequest req) {
//
//        System.out.println(e.getMessage());
//        req.setAttribute("errorMsg",e.getMessage());
//        return "error";
//    }
}
