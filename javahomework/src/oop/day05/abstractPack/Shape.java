/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day05.abstractPack;

/**
 * @program: javaHomework
 * @description: abstracat类
 * @author: xlyu
 * @create: 2019-03-18 09:04
 **/
public abstract class Shape {
    double c;

    public Shape(double c) {
        this.c = c;
    }

    public abstract double area();//抽象类方法不可以有方法体
}
