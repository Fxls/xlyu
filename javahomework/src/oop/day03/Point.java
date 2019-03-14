/**
 * @Author xlyu
 * @Date 2019/3/14 0014
 * @Description
 */
package oop.day03;

/**
 * @program: javahomework
 * @description: 写一个构造器用来计算直角三角形的斜边长度
 * @author: xlyu
 * @create: 2019-03-14 19:02
 **/
public class Point {
    int x;
    int y;

    //默认构造器
    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Point point = new Point(3, 4);
        int z = (int) Math.sqrt((point.x * point.x) + (point.y * point.y));
        System.out.println(z);
    }
}
