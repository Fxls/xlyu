/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day02;

/**
 * @program: javahomework
 * @description: 定义L型方块类
 * @author: xlyu
 * @create: 2019-03-13 15:41
 **/
public class L {
    Cell[] cellsL;

    /**
     * @return
     * @Param
     * @description TODO 构造器
     * @date 2019/3/13 0013 15:39
     */
    public L(int row, int col) {
        cellsL = new Cell[4];
        cellsL[0] = new Cell(row, col);
        cellsL[1] = new Cell(row + 1, col);
        cellsL[2] = new Cell(row + 2, col);
        cellsL[3] = new Cell(row + 2, col + 1);
    }

    /**
     * @return
     * @Param
     * @description TODO 下落
     * @date 2019/3/13 0013 15:39
     */
    public void drop() {
        for (int i = 0; i < cellsL.length; i++) {
            cellsL[i].row++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 左移
     * @date 2019/3/13 0013 15:40
     */
    public void moveLeft() {
        for (int i = 0; i < cellsL.length; i++) {
            cellsL[i].col--;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 右移
     * @date 2019/3/13 0013 15:40
     */
    public void moveRight() {
        for (int i = 0; i < cellsL.length; i++) {
            cellsL[i].col++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 绘制输出面板
     * @date 2019/3/13 0013 15:41
     */
    public void printL(int totalRow, int totalCol, L l) {
        for (int row = 1; row <= totalRow; row++) {
            for (int col = 1; col <= totalCol; col++) {
                boolean iscell = false;
                for (int i = 0; i < cellsL.length; i++) {
                    if (row == cellsL[i].row && col == cellsL[i].col) {
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
        System.out.println();
        for (int col = 1; col <= totalCol; col++) {
            System.out.print(col + "\t");
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 获取单元格位置信息
     * @date 2019/3/13 0013 15:41
     */
    public String getLInfo() {
        String str = " ";
        for (int i = 0; i < cellsL.length; i++) {
            str += "(" + cellsL[i].row + "," + cellsL[i].col + ")";
        }
        System.out.println(str);
        return str;
    }
}
