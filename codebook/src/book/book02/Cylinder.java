/**
 * @Author xlyu
 * @Date 2019/3/15 0015
 * @Description
 */
package book.book02;

import java.util.Scanner;

/**
 * @program: codebook
 * @description: 圆柱类
 * 圆柱体积=π*r²* h=S底面积*高（h）
 * 圆柱体表面积 =2πr²+2πrh
 * @author: xlyu
 * @create: 2019-03-15 16:27
 **/
public class Cylinder extends Circle {
    double h;

    public Cylinder() {
    }

    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    public double Volume(double r, double h) {
        double v = area(r) * h;
        return v;
    }

    public double Surface(double r, double h) {
        double s = area(r) * 2 + length(r) * h;
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入半径：");
        double r = scanner.nextDouble();
        System.out.println("请输入高：");
        double h = scanner.nextDouble();
        Cylinder c = new Cylinder(r, h);
        System.out.println("半径为" + r + "高为" + h + "的圆柱体积是" + c.Volume(r, h));
        System.out.println("半径为" + r + "高为" + h + "的圆柱表面积是" + c.Surface(r, h));
        scanner.close();
    }
}
