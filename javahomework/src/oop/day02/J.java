/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day02;

/**
 * @program: javahomework
 * @description: 定义J型方块类
 * @author: xlyu
 * @create: 2019-03-13 15:43
 **/
public class J {
    Cell[] cellsJ;

    /**
     * @return
     * @Param
     * @description TODO 构造器
     * @date 2019/3/13 0013 15:39
     */
    public J(int row, int col) {
        cellsJ = new Cell[4];
        cellsJ[0] = new Cell(row, col);
        cellsJ[1] = new Cell(row + 1, col);
        cellsJ[2] = new Cell(row + 2, col);
        cellsJ[3] = new Cell(row + 2, col - 1);
    }

    /**
     * @return
     * @Param
     * @description TODO 下落
     * @date 2019/3/13 0013 15:39
     */
    public void drop() {
        for (int i = 0; i < cellsJ.length; i++) {
            cellsJ[i].row++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 左移
     * @date 2019/3/13 0013 15:40
     */
    public void moveLeft() {
        for (int i = 0; i < cellsJ.length; i++) {
            cellsJ[i].col--;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 右移
     * @date 2019/3/13 0013 15:40
     */
    public void moveRight() {
        for (int i = 0; i < cellsJ.length; i++) {
            cellsJ[i].col++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 绘制输出面板
     * @date 2019/3/13 0013 15:41
     */
    public void printJ(int totalRow, int totalCol, J j) {
        for (int row = 1; row <= totalRow; row++) {
            for (int col = 1; col <= totalCol; col++) {
                boolean iscell = false;
                for (int i = 0; i < cellsJ.length; i++) {
                    if (row == cellsJ[i].row && col == cellsJ[i].col) {
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
    public String getJInfo() {
        String str = " ";
        for (int i = 0; i < cellsJ.length; i++) {
            str += "(" + cellsJ[i].row + "," + cellsJ[i].col + ")";
        }
        System.out.println(str);
        return str;
    }
}
