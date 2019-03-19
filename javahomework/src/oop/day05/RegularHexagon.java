/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day05;

/**
 * @program: javahomework
 * @description: 正六边形
 * 周长：c
 * 边长=c/6
 * 小三角形h=[(c/6)/2]*根号三
 * 面积=（根号三/24）*c*c
 * @author: xlyu
 * @create: 2019-03-18 18:27
 **/
public class RegularHexagon extends Shape {
    public RegularHexagon(double c) {
        super(c);
    }

    public double area() {
        return ((Math.sqrt(3)) / 24) * c * c;
    }
}
