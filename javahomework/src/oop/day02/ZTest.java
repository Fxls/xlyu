/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day02;

import java.util.Scanner;

/**
 * @program: javahomework
 * @description: Z型测试
 * @author: xlyu
 * @create: 2019-03-13 16:25
 **/
public class ZTest {
    public static void main(String[] args) {
        System.out.println("原图为：");
        Z z = new Z(3, 3);
        z.printZ(15, 10, z);
        System.out.println("方块位置信息：");
        z.getZInfo();
        do {
            System.out.println("0-退出、1-下落、2-左移、3-右移");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input == 1) {
                z.drop();
                z.printZ(15, 10, z);
                z.getZInfo();
            } else if (input == 2) {
                z.moveLeft();
                z.printZ(15, 10, z);
                z.getZInfo();
            } else if (input == 3) {
                z.moveRight();
                z.printZ(15, 10, z);
                z.getZInfo();
            } else if (input == 0) {
                System.out.println("over!");
                break;
            } else {
                System.out.println("你输入的数字有误");
            }
        } while (true);
    }
}
