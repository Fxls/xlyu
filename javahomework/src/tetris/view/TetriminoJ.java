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
public class TetriminoJ extends Tetrimino {
    //表示四种状态的方块组合
    private static final int DOWN = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int LEFT = 4;
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

    @Override
    public void rotate(boolean dir) {
        switch (state) {
            case UP:
                if (dir) {
                    cells[1] = new Cell(cells[0].row, cells[0].col - 1, backImage);//👉
                    cells[2] = new Cell(cells[0].row, cells[0].col - 2, backImage);
                    cells[3] = new Cell(cells[0].row - 1, cells[0].col - 2, backImage);
                    state = RIGHT;
                } else {
                    cells[1] = new Cell(cells[0].row, cells[0].col + 1, backImage);//←
                    cells[2] = new Cell(cells[0].row, cells[0].col + 2, backImage);
                    cells[3] = new Cell(cells[0].row + 1, cells[0].col + 2, backImage);
                    state = LEFT;
                }
                break;
            case RIGHT:
                if (dir) {
                    cells[1] = new Cell(cells[0].row - 1, cells[0].col, backImage);//👇
                    cells[2] = new Cell(cells[0].row - 2, cells[0].col, backImage);
                    cells[3] = new Cell(cells[0].row - 2, cells[0].col + 1, backImage);
                    state = DOWN;
                } else {
                    cells[1] = new Cell(cells[0].row + 1, cells[0].col, backImage);//👆
                    cells[2] = new Cell(cells[0].row + 2, cells[0].col, backImage);
                    cells[3] = new Cell(cells[0].row + 2, cells[0].col - 1, backImage);
                    state = UP;
                }
                break;
            case DOWN:
                if (dir) {
                    cells[1] = new Cell(cells[0].row, cells[0].col + 1, backImage);//←
                    cells[2] = new Cell(cells[0].row, cells[0].col + 2, backImage);
                    cells[3] = new Cell(cells[0].row + 1, cells[0].col + 2, backImage);
                    state = LEFT;
                } else {
                    cells[1] = new Cell(cells[0].row, cells[0].col - 1, backImage);//👉
                    cells[2] = new Cell(cells[0].row, cells[0].col - 2, backImage);
                    cells[3] = new Cell(cells[0].row - 1, cells[0].col - 2, backImage);
                    state = RIGHT;
                }
                break;
            case LEFT:
                if (dir) {
                    cells[1] = new Cell(cells[0].row + 1, cells[0].col, backImage);//👆
                    cells[2] = new Cell(cells[0].row + 2, cells[0].col, backImage);
                    cells[3] = new Cell(cells[0].row + 2, cells[0].col - 1, backImage);
                    state = UP;
                } else {
                    cells[1] = new Cell(cells[0].row - 1, cells[0].col, backImage);//👇
                    cells[2] = new Cell(cells[0].row - 2, cells[0].col, backImage);
                    cells[3] = new Cell(cells[0].row - 2, cells[0].col + 1, backImage);
                    state = DOWN;
                }
                break;
        }

    }
}
