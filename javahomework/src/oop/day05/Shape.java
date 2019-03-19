/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day05;

/**
 * @program: javahomework
 * @description: 抽象Shape类
 * @author: xlyu
 * @create: 2019-03-18 18:23
 **/
public abstract class Shape {
    double c;

    public Shape(double c) {
        this.c = c;
    }

    public abstract double area();
}
