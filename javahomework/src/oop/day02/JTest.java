/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day02;

import java.util.Scanner;

/**
 * @program: javahomework
 * @description: J型测试
 * @author: xlyu
 * @create: 2019-03-13 16:22
 **/
public class JTest {
    public static void main(String[] args) {
        System.out.println("原图为：");
        J j = new J(3, 3);
        j.printJ(15, 10, j);
        System.out.println("方块位置信息：");
        j.getJInfo();
        do {
            System.out.println("0-退出、1-下落、2-左移、3-右移");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input == 1) {
                j.drop();
                j.printJ(15, 10, j);
                j.getJInfo();
            } else if (input == 2) {
                j.moveLeft();
                j.printJ(15, 10, j);
                j.getJInfo();
            } else if (input == 3) {
                j.moveRight();
                j.printJ(15, 10, j);
                j.getJInfo();
            } else if (input == 0) {
                System.out.println("over!");
                break;
            } else {
                System.out.println("你输入的数字有误");
            }
        } while (true);
    }
}
