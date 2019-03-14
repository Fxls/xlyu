/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day03;


/**
 * @program: javahomework
 * @description: 重构T&J类
 * @author: xlyu
 * @create: 2019-03-13 18:57
 **/
public class Tetromino {
    Cell[] cells;

    /**
     * @return
     * @Param
     * @description TODO 构造器
     * @date 2019/3/13 0013 19:06
     */
    public Tetromino() {
        cells = new Cell[4];
    }


    /**
     * @return
     * @Param
     * @description TODO 下降
     * @date 2019/3/13 0013 19:02
     */
    public void drop() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].row++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 左移
     * @date 2019/3/13 0013 19:32
     */
    public void moveLeft() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].col--;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 右移
     * @date 2019/3/13 0013 19:33
     */
    public void moveRight() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].col++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 位置信息打印
     * @date 2019/3/13 0013 19:35
     */
    public String getCellInfo() {
        String str = " ";
        for (int i = 0; i < cells.length; i++) {
            str += "(" + cells[i].row + "," + cells[i].col + ")";
        }
        System.out.println(str);
        return str;
    }
}