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
 * @create: 2019-06-26 09:18
 **/
public class ShopTest {
    public static void main(String[] args) {
        String config = "shop.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Shop shop = (Shop) ac.getBean("shop");
        shop.print();

    }
}
