/**
 * @Author xlyu
 * @Date 2019/3/19 0019
 * @Description
 */
package tetris.view;

import java.awt.*;

/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-19 13:32
 **/
public class TetriminoS extends Tetrimino {
    //表示两种状态的方块组合
    private static final int TRANSVERSE = 1;
    private static final int VERTICAL = 2;
    //接收方块状态的变量
    private int state;

    public TetriminoS(int row, int col, Image backImage) {
        super(row, col, backImage);
        cells[0] = new Cell(row, col, backImage);
        cells[1] = new Cell(row + 1, col - 1, backImage);
        cells[2] = new Cell(row + 1, col, backImage);
        cells[3] = new Cell(row, col + 1, backImage);
        state = TRANSVERSE;
    }

    @Override
    public void rotate(boolean dir) {
        switch (state) {
            case TRANSVERSE:
                cells[1] = new Cell(cells[0].row + 1, cells[0].col + 1, backImage);
                cells[2] = new Cell(cells[0].row, cells[0].col + 1, backImage);
                cells[3] = new Cell(cells[0].row - 1, cells[0].col, backImage);
                state = VERTICAL;
                break;
            case VERTICAL:
                cells[1] = new Cell(cells[0].row + 1, cells[0].col - 1, backImage);
                cells[2] = new Cell(cells[0].row + 1, cells[0].col, backImage);
                cells[3] = new Cell(cells[0].row, cells[0].col + 1, backImage);
                state = TRANSVERSE;
                break;
        }

    }
}
