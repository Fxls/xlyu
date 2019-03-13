/**
 * @Author xlyu
 * @Date 2019/3/12 0012
 * @Description
 */
package oop.day02;

import java.util.Scanner;

/**
 * @program: javahomework
 * @description: 用于测试O类,“田”型方块移动的实现，0-退出、1-下降一个单位、2-左移一个单位、3-右移一个单位
 * @author: xlyu
 * @create: 2019-03-12 17:31
 **/
public class OTest {
    public static void main(String[] args) {
        /**输出初始图形*/
        System.out.println("原图为：");
        O o = new O(3, 3);//参数含义为中心单元格坐标为（3，3）
        o.printO(o);
        System.out.println("位置为：");
        o.getOInfo();
        /**do-while实现循环交互效果，输入0时退出*/
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入数字控制：0-退出、1-整体下降一格、2-整体左移一格、3-整体右移一格");
            int input = scanner.nextInt();
            /**if分支语句实现不同数字的功能*/
            if (input == 1) {
                o.drop(1);
                o.printO(o);
            } else if (input == 2) {
                o.moveLeft(2);
                o.printO(o);
            } else if (input == 3) {
                o.moveRight(3);
                o.printO(o);
            } else if (input == 0) {
                System.out.println("终止操作！");
                break;
            } else {
                System.out.println("您输入的数字有误！");
            }
            o.getOInfo();//打印坐标
        } while (true);

    }
}
