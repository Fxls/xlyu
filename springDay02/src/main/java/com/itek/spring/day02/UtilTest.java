/**
 * @Author xlyu
 * @Date 2019/6/26
 * @Description
 */
package com.itek.spring.day02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDay02
 * @description:
 * @author: xlyu
 * @create: 2019-06-26 10:23
 **/
public class UtilTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("util.xml");
        Shop shop = (Shop) ac.getBean("shop");
        shop.print();

    }
}
