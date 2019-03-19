/**
 * @Author xlyu
 * @Date 2019/3/19 0019
 * @Description
 */
package tetris.view;

import java.awt.*;

/**
 * @program: javahomework
 * @description: 方块组合
 * @author: xlyu
 * @create: 2019-03-19 13:15
 **/
public class Tetrimino {
    Image backImage;
    Cell[] cells;
    int row;
    int col;

    public Tetrimino() {
        row = 1;
        col = 1;
    }

    public Tetrimino(int row, int col, Image backImage) {
        this.backImage = backImage;
        cells = new Cell[4];
        this.row = row;
        this.col = col;

    }

    public void paint(Graphics g) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].paint(g);
        }
    }


    public void paint(Graphics g, int x, int y) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].paint(g, x, y);
        }
    }

    public void drop() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].drop();
        }
    }

    public void moveLeft() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].moveLeft();
        }
    }

    public void moveRight() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].moveRight();
        }
    }
}
