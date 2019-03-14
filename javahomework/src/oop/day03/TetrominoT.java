/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day03;

/**
 * @program: javahomework
 * @description:重构T类继承Tetromino
 * @author: xlyu
 * @create: 2019-03-13 19:48
 **/
public class TetrominoT extends Tetromino {
    public TetrominoT(int row, int col) {
        super();//调用父类无参数构造方法
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row, col - 1);
        cells[2] = new Cell(row, col + 1);
        cells[3] = new Cell(row + 1, col);
    }

    public static void main(String[] args) {
        TetrominoT t = new TetrominoT(3, 3);
        t.getCellInfo();
        t.print(10, 15);
    }
}
