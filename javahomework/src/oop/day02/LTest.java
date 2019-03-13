/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day02;

import java.util.Scanner;

/**
 * @program: javahomework
 * @description: L型测试
 * @author: xlyu
 * @create: 2019-03-13 16:23
 **/
public class LTest {
    public static void main(String[] args) {
        System.out.println("原图为：");
        L l = new L(3, 3);
        l.printL(15, 10, l);
        System.out.println("方块位置信息：");
        l.getLInfo();
        do {
            System.out.println("0-退出、1-下落、2-左移、3-右移");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input == 1) {
                l.drop();
                l.printL(15, 10, l);
                l.getLInfo();
            } else if (input == 2) {
                l.moveLeft();
                l.printL(15, 10, l);
                l.getLInfo();
            } else if (input == 3) {
                l.moveRight();
                l.printL(15, 10, l);
                l.getLInfo();
            } else if (input == 0) {
                System.out.println("over!");
                break;
            } else {
                System.out.println("你输入的数字有误");
            }
        } while (true);
    }
}
