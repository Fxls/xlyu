/**
 * @Author xlyu
 * @Date 2019/3/19 0019
 * @Description
 */
package tetris.view;

import java.awt.*;
import java.io.Serializable;

/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-19 13:32
 **/
public class TetriminoJ extends Tetrimino implements Serializable {

    //表示四种状态的方块组合
    private static final int DOWN = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int LEFT = 4;
    private static final long serialVersionUID = -3609348721425092786L;
    //用于接收状态的变量
    private int state;

    public TetriminoJ(int row, int col, Image backImage) {
        super(row, col, backImage);
        cells[0] = new Cell(row, col, backImage);
        cells[1] = new Cell(row + 1, col, backImage);
        cells[2] = new Cell(row + 2, col, backImage);
        cells[3] = new Cell(row + 2, col - 1, backImage);
        state = UP;
    }

    /**
     * @return void
     * @Param dir={}
     * @description TODO 形态枚举
     * @date 2019/3/21 0021 15:42
     */
    @Override
    public void rotate(boolean dir) {
        switch (state) {
            case UP:
                if (dir) {
                    right();
                } else {
                    left();
                }
                break;
            case RIGHT:
                if (dir) {
                    down();
                } else {
                    up();
                }
                break;
            case DOWN:
                if (dir) {
                    left();
                } else {
                    right();
                }
                break;
            case LEFT:
                if (dir) {
                    up();
                } else {
                    down();
                }
                break;
        }

    }

    private void up() {
        cells[1] = new Cell(cells[0].row + 1, cells[0].col, backImage);//👆
        cells[2] = new Cell(cells[0].row + 2, cells[0].col, backImage);
        cells[3] = new Cell(cells[0].row + 2, cells[0].col - 1, backImage);
        state = UP;
    }

    private void down() {
        cells[1] = new Cell(cells[0].row - 1, cells[0].col, backImage);//👇
        cells[2] = new Cell(cells[0].row - 2, cells[0].col, backImage);
        cells[3] = new Cell(cells[0].row - 2, cells[0].col + 1, backImage);
        state = DOWN;
    }

    private void left() {
        cells[1] = new Cell(cells[0].row, cells[0].col + 1, backImage);//←
        cells[2] = new Cell(cells[0].row, cells[0].col + 2, backImage);
        cells[3] = new Cell(cells[0].row + 1, cells[0].col + 2, backImage);
        state = LEFT;
    }

    private void right() {
        cells[1] = new Cell(cells[0].row, cells[0].col - 1, backImage);//👉
        cells[2] = new Cell(cells[0].row, cells[0].col - 2, backImage);
        cells[3] = new Cell(cells[0].row - 1, cells[0].col - 2, backImage);
        state = RIGHT;
    }
}
