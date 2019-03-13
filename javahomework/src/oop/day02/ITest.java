/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day02;

import java.util.Scanner;

/**
 * @program: javahomework
 * @description: I型测试
 * @author: xlyu
 * @create: 2019-03-13 16:22
 **/
public class ITest {
    public static void main(String[] args) {
        System.out.println("原图为：");
        I i = new I(3, 3);
        i.printI(15, 10, i);
        System.out.println("方块位置信息：");
        i.getIInfo();
        do {
            System.out.println("0-退出、1-下落、2-左移、3-右移");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input == 1) {
                i.drop();
                i.printI(15, 10, i);
                i.getIInfo();
            } else if (input == 2) {
                i.moveLeft();
                i.printI(15, 10, i);
                i.getIInfo();
            } else if (input == 3) {
                i.moveRight();
                i.printI(15, 10, i);
                i.getIInfo();
            } else if (input == 0) {
                System.out.println("over!");
                break;
            } else {
                System.out.println("你输入的数字有误");
            }
        } while (true);
    }
}
