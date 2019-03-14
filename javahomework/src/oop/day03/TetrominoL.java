/**
 * @Author xlyu
 * @Date 2019/3/14 0014
 * @Description
 */
package oop.day03;

/**
 * @program: javahomework
 * @description: 重构L类继承Tetromino
 * @author: xlyu
 * @create: 2019-03-14 14:32
 **/
public class TetrominoL extends Tetromino {
    public TetrominoL(int row, int col) {
        super();
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row + 1, col);
        cells[2] = new Cell(row + 2, col);
        cells[3] = new Cell(row + 2, col + 1);
    }

    public static void main(String[] args) {
        TetrominoL l = new TetrominoL(3, 3);
        l.getCellInfo();
        l.print(10, 15);
    }
}
