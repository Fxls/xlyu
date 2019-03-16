/**
 * @Author xlyu
 * @Date 2019/3/15 0015
 * @Description
 */
package book.book02;

import java.util.Scanner;

/**
 * @program: codebook
 * @description: 圆锥类：圆锥体积v=(1/3)*pi*r*r*h-------------等价于（1/3*area*h）
 * h=根号下l^2-r^2
 * s=pi*r*l
 * @author: xlyu
 * @create: 2019-03-15 19:06
 **/
public class Cone extends Circle {
    double l;//圆锥母线

    public Cone() {
    }

    public Cone(double r, double l) {
        this.l = l;
    }

    public double Volume(double r, double l) {
        double v = (1.0 / 3) * (Math.sqrt((l * l) - (r * r))) * area(r);
        return v;
    }

    public double Surface(double r, double l) {
        double s = length(r) * l * (1.0 / 2);
        return s;
    }

    public static void main(String[] args) {
        //这里注意圆锥母线一定比半径长，否则为圆台
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入半径：");
        double r = scanner.nextDouble();
        System.out.println("请输入母线长度：");
        double l = scanner.nextDouble();
        Cone c = new Cone(r, l);
        System.out.println("半径为" + r + "母线为" + l + "的圆锥体积是" + c.Volume(r, l));
        System.out.println("半径为" + r + "母线为" + l + "的圆锥表面积是" + c.Surface(r, l));
        scanner.close();
    }
}
