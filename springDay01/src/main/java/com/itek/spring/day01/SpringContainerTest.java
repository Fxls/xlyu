/**
 * @Author xlyu
 * @Date 2019/6/24
 * @Description
 */
package com.itek.spring.day01;

import com.itek.spring.day01.module.Multiple;
import com.itek.spring.day01.module.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDay01
 * @description:
 * @author: xlyu
 * @create: 2019-06-24 09:29
 **/
public class SpringContainerTest {
    public static void main(String[] args) {
        //声明配置文件名
        String springConfig = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(springConfig);
        ((ClassPathXmlApplicationContext) ac).close();


//        System.out.println(ac.getBean("muti", Multiple.class));

        /**
         * 创建对象（使用spring）
         * getBean中传入参数为配置文件中的id
         * 返回类型是Object，需要注意
         */

//        User user = (User) ac.getBean("d1");
//        User user1 = (User) ac.getBean("user");
        /**
         * spring的bean的默认模式为单例模式:true
         */
//        System.out.println(user == user1);
//
//        Multiple multiple = (Multiple) ac.getBean("muti");
//        Multiple multiple2 = (Multiple) ac.getBean("muti");
        /**
         * false
         */
//        System.out.println(multiple == multiple2);





    }
}
