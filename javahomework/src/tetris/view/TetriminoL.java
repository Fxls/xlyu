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
public class TetriminoL extends Tetrimino {
    public TetriminoL(int row, int col, Image backImage) {
        super(row, col, backImage);
        cells[0] = new Cell(row, col, backImage);
        cells[1] = new Cell(row + 1, col, backImage);
        cells[2] = new Cell(row + 2, col, backImage);
        cells[3] = new Cell(row + 2, col + 1, backImage);

    }

}
