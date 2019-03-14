/**
 * @Author xlyu
 * @Date 2019/3/14 0014
 * @Description
 */
package oop.day03;

import java.util.Scanner;

/**
 * @program: javahomework
 * @description: 重构I类继承Tetromino
 * @author: xlyu
 * @create: 2019-03-14 14:33
 **/
public class TetrominoI extends Tetromino {
    public TetrominoI(int row, int col) {
        super();
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row + 1, col);
        cells[2] = new Cell(row + 2, col);
        cells[3] = new Cell(row + 3, col);
    }

    public static void main(String[] args) {

        TetrominoI i = new TetrominoI(3, 3);
        i.print(10, 15);
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入数字：0-退出、1-下落、2-左移、3-右移");
            int input = scanner.nextInt();
            if (input == 1) {
                i.drop();
                i.print(10, 15);
                i.getCellInfo();
            } else if (input == 2) {
                i.moveLeft();
                i.print(10, 15);
                i.getCellInfo();
            } else if (input == 3) {
                i.moveRight();
                i.print(10, 15);
                i.getCellInfo();
            } else if (input == 0) {
                System.out.println("over");
                break;
            } else {
                System.out.println("再输一次！");
            }
        } while (true);
    }

}
