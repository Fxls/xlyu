/**
 * @Author xlyu
 * @Date 2019/6/25
 * @Description
 */
package com.itek.spring.day01;

import com.itek.spring.day01.module.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDay01
 * @description:
 * @author: xlyu
 * @create: 2019-06-25 09:09
 **/
public class SpringContainerTest2 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        Computer computer = ac.getBean("pc2", Computer.class);
        System.out.println(computer);
    }
}
