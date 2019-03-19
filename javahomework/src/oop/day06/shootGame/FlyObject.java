/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day06.shootGame;

/**
 * @program: javahomework
 * @description: 飞行物类
 * @author: xlyu
 * @create: 2019-03-18 19:44
 **/
public abstract class FlyObject {
    double x;//横坐标
    double y;//纵坐标

    public FlyObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void fly();
}
