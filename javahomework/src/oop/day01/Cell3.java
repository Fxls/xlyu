/**
 * @Author xlyu
 * @Date 2019/3/11 0011
 * @Description
 */
package oop.day01;

import java.util.Scanner;

/**
 * @program: javaHomework
 * @description:1、下落1格 2、左移一个 3、右移一格 0、退出
 * @author: xlyu
 * @create: 2019-03-11 19:07
 **/
public class Cell3 {
    public static void main(String[] args) {
        Cell cell = new Cell();
        cell.row = 3;//*所在的行数
        cell.col = 3;//*所在的列数
        String string = cell.getCellInfo();
        System.out.println("原图为：---------" + "坐标为" + string);
        printCell(cell);
        do {
            System.out.println("1、下降一格，2、左移一格，3、右移一格，0、退出");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();//下移i
            if (n == 1) {
                cell.drop(n);
                printCell(cell);
            } else if (n == 2) {
                cell.moveLeft(n);
                printCell(cell);
            } else if (n == 3) {
                cell.moveRight(n);
                printCell(cell);
            } else if (n == 0) {
                System.out.println("over");
                break;
            } else {
                System.out.println("输入错误！");
            }
        } while (true);
//        System.out.println("over");
    }

    public static void printCell(Cell cell) {
        int totalRow = 9;
        int totalCol = 9;
        for (int row = 1; row <= totalRow; row++) {
            for (int col = 1; col <= totalCol; col++) {
                if (cell.row == row && cell.col == col) {
                    System.out.print("*" + "\t");
                } else {
                    System.out.print("-" + "\t");
                }
            }
            System.out.println(row);
        }
        for (int i = 1; i <= totalCol; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

    }
}
