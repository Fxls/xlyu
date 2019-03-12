/**
 * @Author xlyu
 * @Date 2019/3/12 0012
 * @Description
 */
package oop.day02;

import java.util.Scanner;

/**
 * @program: javahomework
 * @description: 操作面板
 * @author: xlyu
 * @create: 2019-03-12 15:06
 **/
public class Panel {
    public static void main(String[] args) {
        Cell cell = new Cell(3, 3);//这里是因为创建了构造方法，需要注意参数的输入
        String str = cell.getCellInfo();
        System.out.println("左边位置为：" + str);
        cell.printCell(cell);
        /**do-while循环执行用户输入*/
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入数字：0-退出、1-下落、2-左移一格、3-右移一格.");
            int input = scanner.nextInt();
            //输入不同数字的不同情况
            if (input == 1) {
                cell.drop(1);
                cell.printCell(cell);
            } else if (input == 2) {
                cell.moveLeft(2);
                cell.printCell(cell);
            } else if (input == 3) {
                cell.moveRight(3);
                cell.printCell(cell);
            } else if (input == 0) {
                System.out.println("终止操作！");
                break;
            } else {
                System.out.println("你输入的数字有误！");
            }
        } while (true);
    }
}
