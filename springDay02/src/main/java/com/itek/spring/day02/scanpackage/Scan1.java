/**
 * @Author xlyu
 * @Date 2019/6/26
 * @Description
 */
package com.itek.spring.day02.scanpackage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @program: springDay02
 * @description:
 * @author: xlYu
 * @create: 2019-06-26 19:47
 **/
@Component
@Lazy(false)
public class Scan1 {

    public Scan1() {
    }

    public Scan1(String name) {
        this.name = name;
        System.out.println("含参构造器！");
    }

    @Value("扫描类1")
    private String name;

    @Override
    public String toString() {
        return "Scan1{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    /**
     * @PostConstruct: 初始化回调注入
     */
    @PostConstruct
    public void init() {
        System.out.println("init-method");
    }

    /**
     * @PreDestroy: 销毁回调注入
     */
    @PreDestroy
    public void destroy() {
        System.out.println("destroy-method");
    }
}
