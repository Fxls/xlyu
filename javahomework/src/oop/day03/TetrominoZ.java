/**
 * @Author xlyu
 * @Date 2019/3/14 0014
 * @Description
 */
package oop.day03;

/**
 * @program: javahomework
 * @description: 重构Z类继承Tetromino
 * @author: xlyu
 * @create: 2019-03-14 14:32
 **/
public class TetrominoZ extends Tetromino {
    public TetrominoZ(int row, int col) {
        super();
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row, col + 1);
        cells[2] = new Cell(row + 1, col + 1);
        cells[3] = new Cell(row + 1, col + 2);
    }

    public static void main(String[] args) {
        TetrominoZ z = new TetrominoZ(3, 3);
        z.getCellInfo();
        z.print(10, 15);
    }
}
