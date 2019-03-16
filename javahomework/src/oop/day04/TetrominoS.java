/**
 * @Author xlyu
 * @Date 2019/3/14 0014
 * @Description
 */
package oop.day04;

/**
 * @program: javahomework
 * @description: 重构S类继承Tetromino
 * @author: xlyu
 * @create: 2019-03-14 14:33
 **/
public class TetrominoS extends Tetromino {
    public TetrominoS(int row, int col) {
        super();
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row, col + 1);
        cells[2] = new Cell(row - 1, col + 1);
        cells[3] = new Cell(row - 1, col + 2);
    }

    public static void main(String[] args) {
        TetrominoS s = new TetrominoS(3, 3);
        s.getCellInfo();
        s.print();
        s.Start(s);
    }
}
