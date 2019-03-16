/**
 * @Author xlyu
 * @Date 2019/3/14 0014
 * @Description
 */
package oop.day04;

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
        i.print();
        i.getCellInfo();
        i.Start(i);
    }
}
