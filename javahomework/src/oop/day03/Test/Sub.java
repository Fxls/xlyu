/**
 * @Author xlyu
 * @Date 2019/3/14 0014
 * @Description
 */
package oop.day03.Test;

/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-14 16:00
 **/
public class Sub extends Base {
    String color;

    public Sub(double size, String name, String color) {
        super(size, name);
        this.color = color;
    }

    public static void main(String[] args) {
        Sub s = new Sub(5.6, "测试对象", "红色");
        System.out.println(s.size + "-" + s.name + "-" + s.color);
    }
}
