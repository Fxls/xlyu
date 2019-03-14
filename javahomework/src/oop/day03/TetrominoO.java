/**
 * @Author xlyu
 * @Date 2019/3/14 0014
 * @Description
 */
package oop.day03;

/**
 * @program: javahomework
 * @description: 重构O类继承Tetromino
 * @author: xlyu
 * @create: 2019-03-14 14:31
 **/
public class TetrominoO extends Tetromino {
    public TetrominoO(int row, int col) {
        super();
        cells[0] = new Cell(row, col);//左上角方块
        cells[1] = new Cell(row, col + 1);//右上角方块
        cells[2] = new Cell(row + 1, col);//左下角方块
        cells[3] = new Cell(row + 1, col + 1);//右下角方块
    }

    public static void main(String[] args) {
        TetrominoO o = new TetrominoO(3, 3);
        o.getCellInfo();
        o.print(10, 15);
    }
}
