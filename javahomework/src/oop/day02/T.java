/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day02;

/**
 * @program: javahomework
 * @description: 定义T型方块类
 * @author: xlyu
 * @create: 2019-03-13 15:11
 **/
public class T {
    Cell[] cellsT;

    /**
     * @return
     * @Param
     * @description TODO 构造器
     * @date 2019/3/13 0013 15:12
     */

    public T(int row, int col) {
        cellsT = new Cell[4];
        cellsT[0] = new Cell(row, col);
        cellsT[1] = new Cell(row, col - 1);
        cellsT[2] = new Cell(row, col + 1);
        cellsT[3] = new Cell(row + 1, col);
    }

    /**
     * @return
     * @Param
     * @description TODO 方法：下落
     * @date 2019/3/13 0013 15:16
     */
    public void drop() {
        for (int i = 0; i < cellsT.length; i++) {
            cellsT[i].row++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 方法：左移
     * @date 2019/3/13 0013 15:19
     */
    public void moveLeft() {
        for (int i = 0; i < cellsT.length; i++) {
            cellsT[i].col--;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 方法：右移
     * @date 2019/3/13 0013 15:20
     */
    public void moveRight() {
        for (int i = 0; i < cellsT.length; i++) {
            cellsT[i].col++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 方法：绘制输出面板
     * @date 2019/3/13 0013 15:22
     */
    public void printT(int totalRow, int totalCol, T t) {
        for (int row = 1; row <= totalRow; row++) {
            for (int col = 1; col <= totalCol; col++) {
                boolean iscell = false;
                for (int i = 0; i < cellsT.length; i++) {
                    if (row == cellsT[i].row && col == cellsT[i].col) {
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

    /**
     * @return
     * @Param
     * @description TODO 获取积木位置信息
     * @date 2019/3/13 0013 15:35
     */
    public String getTInfo() {
        String str = " ";
        for (int i = 0; i < cellsT.length; i++) {
            str += "" + "(" + cellsT[i].row + "," + cellsT[i].col + ")";
        }
        System.out.println(str);
        return str;
    }

}
