/**
 * @Author xlyu
 * @Date 2019/6/26
 * @Description
 */
package com.itek.spring.day02;

import com.itek.spring.day02.scanpackage.Scan1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDay02
 * @description:
 * @author: xlyu
 * @create: 2019-06-26 10:45
 **/
public class ScanTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("componentScan.xml");
        Scan1 scan1 = (Scan1) ac.getBean("scan1");
        System.out.println(scan1);

        ((ClassPathXmlApplicationContext) ac).close();
    }
}
