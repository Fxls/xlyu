/**
 * @Author xlYu
 * @Date 2019/6/26
 * @Description
 */
package com.itek.spring.day02.module;

import org.springframework.stereotype.Component;

/**
 * @program: springDay02
 * @description:
 * @author: xlYu
 * @create: 2019-06-26 10:44
 **/
@Component
public class User {
    public User() {
        System.out.println("**构造器**");
    }
}
