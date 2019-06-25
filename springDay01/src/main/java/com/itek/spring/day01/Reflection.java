/**
 * @Author xlyu
 * @Date 2019/6/25
 * @Description
 */
package com.itek.spring.day01;

import com.itek.spring.day01.module.Computer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @program: springDay01
 * @description: java反射机制
 * @author: xlyu
 * @create: 2019-06-25 19:26
 **/
public class Reflection {
    public static void main(String[] args) throws Exception {
        /**
         * 获取当前类的类加载器
         */
        ClassLoader c = Reflection.class.getClassLoader();
        /**
         * 加载类对象
         */
        Class clazz = c.loadClass("com.itek.spring.day01.module.Computer");
        /**
         * 获取类对象的无参构造器
         */
        Constructor constructor = clazz.getConstructor();
        /**
         * 获取类对象的含参构造
         */
        Constructor constructor1 = clazz.getConstructor(String.class, double.class, String.class);
        /**
         * 使用获取到的构造器创建对象
         */
        Computer computer = (Computer) constructor.newInstance();
        Computer computer1 = (Computer) constructor1.newInstance("huawei", 4000.0, "i7");
        System.out.println(computer);
        System.out.println(computer1);
        /**
         * 通过类对象获取方法
         */
        Method method = clazz.getMethod("print");
        /**
         * invoke此方法,传入具体对象
         */
        method.invoke(computer1);
    }
}
