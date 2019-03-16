/**
 * @Author xlyu
 * @Date 2019/3/15 0015
 * @Description
 */
package book.book02;

import java.util.Scanner;

/**
 * @program: codeBook
 * @description:设计圆类，定义这个类用于计算周长和面积
 * @author: xlyu
 * @create: 2019-03-15 16:02
 **/
public class Circle {
    double r;
    double pi = Math.PI;

    public Circle() {
    }

    public Circle(double r) {
        this.r = r;

    }

    public double area(double r) {
        this.r = r;
        double area = pi * r * r;
        return area;
    }

    public double length(double r) {
        this.r = r;
        double length = 2 * pi * r;
        return length;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入半径：");
        double r = scanner.nextDouble();
        Circle c = new Circle(r);
        System.out.println("半径为" + r + "的圆，面积为" + c.area(r));
        System.out.println("半径为" + r + "的圆，周长为" + c.length(r));
        scanner.close();
    }
}
