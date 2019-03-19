/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day05.abstractPack;

import oop.day05.abstractPack.Shape;

/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-18 09:26
 **/
public class Square extends Shape {
    public Square(double c) {
        super(c);
    }

    public double area() {
        return 0.06525 * c * c;
    }
}
