/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day05.interfacePack;

/**
 * @program: javahomework
 * @description: 接口
 * @author: xlyu
 * @create: 2019-03-18 11:00
 **/
public class Interface {
    interface A {
        public static String INFO = "Hello World!";

        public void print();

        default public void otherprint() {
            System.out.println("default methods");
        }
    }
}
