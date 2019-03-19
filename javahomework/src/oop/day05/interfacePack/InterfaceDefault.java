/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day05.interfacePack;

/**
 * @program: javahomework
 * @description: 带default方法接口的实现
 * @author: xlyu
 * @create: 2019-03-18 11:05
 **/
interface InterfaceA {//定义一个接口
    public static String INFO = "static final";//全局变量

    public void print();//抽象方法

    default public void otherprint() {//带方法体的默认方法
        System.out.println("print default 1 methods InterfaceA");
    }
}

class subClass implements InterfaceA {//子类InterfaceA实现接口InterfaceA

    public void print() {//实现接口中的抽象方法print
        System.out.println("print abstract methods InterfaceA");
        System.out.println(INFO);
    }
}

public class InterfaceDefault {
    public static void main(String[] args) {
        subClass subObj = new subClass();//实例化子类对象
        subObj.print();//调用"实现过"的抽象方法
        subObj.otherprint();//调用接口中的默认方法
        System.out.println(InterfaceA.INFO);//输出接口中的常量
    }
}


