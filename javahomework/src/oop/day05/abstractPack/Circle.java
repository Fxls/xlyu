/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day05.abstractPack;

/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-18 09:08
 **/
public class Circle extends Shape {
    public Circle(double c) {
        super(c);
    }

    public double area() {//继承抽象类，必须重写其方法
        return 0.0796 * c * c;
    }
}
