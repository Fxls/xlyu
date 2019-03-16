/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day04;

/**
 * @program: javahomework
 * @description: 重构J类继承Tetromino
 * @author: xlyu
 * @create: 2019-03-13 19:52
 **/
public class TetrominoJ extends Tetromino {
    public TetrominoJ(int row, int col) {
        super();//调用父类无参数构造方法
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row + 1, col);
        cells[2] = new Cell(row + 2, col);
        cells[3] = new Cell(row + 2, col - 1);
    }

    public static void main(String[] args) {
        TetrominoJ j = new TetrominoJ(3, 3);
        j.getCellInfo();
        j.print();
        j.Start(j);
    }
}
