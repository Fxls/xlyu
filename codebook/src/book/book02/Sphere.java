/**
 * @Author xlyu
 * @Date 2019/3/15 0015
 * @Description
 */
package book.book02;

import java.util.Scanner;

/**
 * @program: codebook
 * @description: 球体v=(4.0/3)*pi*r^3
 * s=4*pi*r*r
 * @author: xlyu
 * @create: 2019-03-15 19:57
 **/
public class Sphere extends Circle {
    public Sphere(double r) {

    }

    public double Volume(double r) {
        double v = (4.0 / 3) * area(r) * r;
        return v;
    }

    public double Surface(double r) {
        double s = 4 * area(r);
        return s;
    }

    public static void main(String[] args) {
        //这里注意圆锥母线一定比半径长，否则为圆台
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入半径：");
        double r = scanner.nextDouble();
        Sphere s = new Sphere(r);
        System.out.println("半径为" + r + "的球体积是" + s.Volume(r));
        System.out.println("半径为" + r + "的球表面积是" + s.Surface(r));
        scanner.close();
    }
}
