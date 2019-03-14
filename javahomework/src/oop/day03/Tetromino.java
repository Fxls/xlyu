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
            cells[i].drop();
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
            cells[i].moveLeft();
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
            cells[i].moveRight();
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

    /**
     * @return
     * @Param
     * @description TODO 图形的打印
     * @date 2019/3/14 0014 13:47
     */
    public void print(int totalRow, int totalCol) {
        for (int row = 1; row <= totalRow; row++) {
            for (int col = 1; col <= totalCol; col++) {
                boolean iscell = false;
                for (int index = 0; index < cells.length; index++) {
                    if (row == cells[index].row && col == cells[index].col) {
                        iscell = true;
                    }
                }
                if (iscell == true) {
                    System.out.print("*" + "\t");
                } else {
                    System.out.print("-" + "\t");
                }
            }
            System.out.println(row);
        }
        for (int col = 1; col <= totalCol; col++) {
            System.out.print(col + "\t");
        }
        System.out.println();
    }

}