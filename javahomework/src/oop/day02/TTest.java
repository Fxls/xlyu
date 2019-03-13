/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day02;

import java.util.Scanner;

/**
 * @program: javahomework
 * @description: T型测试
 * @author: xlyu
 * @create: 2019-03-13 16:24
 **/
public class TTest {
    public static void main(String[] args) {
        System.out.println("原图为：");
        T t = new T(3, 3);
        t.printT(15, 10, t);
        System.out.println("方块位置信息：");
        t.getTInfo();
        do {
            System.out.println("0-退出、1-下落、2-左移、3-右移");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input == 1) {
                t.drop();
                t.printT(15, 10, t);
                t.getTInfo();
            } else if (input == 2) {
                t.moveLeft();
                t.printT(15, 10, t);
                t.getTInfo();
            } else if (input == 3) {
                t.moveRight();
                t.printT(15, 10, t);
                t.getTInfo();
            } else if (input == 0) {
                System.out.println("over!");
                break;
            } else {
                System.out.println("你输入的数字有误");
            }
        } while (true);
    }
}
