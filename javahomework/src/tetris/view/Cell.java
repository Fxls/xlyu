/**
 * @Author xlyu
 * @Date 2019/3/19 0019
 * @Description
 */
package tetris.view;

import java.awt.*;

/**
 * @program: javahomework
 * @description: 方块
 * @author: xlyu
 * @create: 2019-03-19 13:17
 **/
public class Cell {
    int row;
    int col;
    Image backImage;

    /**
     * @return
     * @Param
     * @description TODO 构造器
     * @date 2019/3/19 0019 17:46
     */

    public Cell(int row, int col, Image backImage) {
        this.row = row;
        this.col = col;
        this.backImage = backImage;
    }

    /**
     * @return
     * @Param
     * @description TODO 重写paint方法
     * @date 2019/3/19 0019 17:47
     */

    public void paint(Graphics g) {
        g.drawImage(backImage,
                (col - 1) * backImage.getHeight(null) + 15,
                (row - 1) * backImage.getWidth(null) + 15,
                null);
    }

    /**
     * @return
     * @Param
     * @description TODO 重构paint方法
     * @date 2019/3/19 0019 17:47
     */

    public void paint(Graphics g, int x, int y) {
        g.drawImage(backImage,
                (col - 1) * backImage.getHeight(null) + 15 + x,
                (row - 1) * backImage.getWidth(null) + 15 + y,
                null);
    }

    public void drop() {
        row++;
    }

    public void moveLeft() {
        col--;
    }

    public void moveRight() {
        col++;
    }
}
