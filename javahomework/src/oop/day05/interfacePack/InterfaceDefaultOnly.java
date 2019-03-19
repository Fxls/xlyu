/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day05.interfacePack;

/**
 * @program: javaHomework
 * @description: 仅有default方法接口的使用
 * @author: xlyu
 * @create: 2019-03-18 11:23
 **/
interface InterfaceA2 {//定义一个接口
    default public void otherprint() {//带方法体的默认方法
        System.out.println("print default methods only in InterfaceA2!");
    }
}

class subClass2 implements InterfaceA2 {//子类实现接口
    //nothing
}

public class InterfaceDefaultOnly {
    public static void main(String[] args) {
        subClass2 subObj = new subClass2();
        subObj.otherprint();
    }
}
