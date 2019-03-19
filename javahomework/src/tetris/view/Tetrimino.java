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

    /**
     * @return
     * @Param
     * @description TODO 无参构造
     * @date 2019/3/19 0019 17:06
     */
    public Tetrimino() {
        row = 1;
        col = 1;
    }

    /**
     * @return
     * @Param
     * @description TODO 含参构造
     * @date 2019/3/19 0019 17:07
     */

    public Tetrimino(int row, int col, Image backImage) {
        this.backImage = backImage;
        cells = new Cell[4];
        this.row = row;
        this.col = col;

    }

    /**
     * @return void
     * @Param g={}
     * @description TODO 重写paint方法
     * @date 2019/3/19 0019 17:12
     */
    public void paint(Graphics g) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].paint(g);
        }
    }

    /**
     * @return void
     * @Param g={调用画笔}, x={横坐标}, y={纵坐标}
     * @description TODO 重构上面的paint方法
     * @date 2019/3/19 0019 17:12
     */

    public void paint(Graphics g, int x, int y) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].paint(g, x, y);
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 下落方法，方法体中调用Cell中的drop
     * @date 2019/3/19 0019 17:44
     */

    public void drop() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].drop();
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 左移方法，方法体中调用Cell中的moveLeft
     * @date 2019/3/19 0019 17:45
     */
    public void moveLeft() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].moveLeft();
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 右移方法，方法体中调用Cell中的moveRight
     * @date 2019/3/19 0019 17:46
     */
    public void moveRight() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].moveRight();
        }
    }
}
