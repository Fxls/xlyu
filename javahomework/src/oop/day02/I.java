/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day02;

/**
 * @program: javahomework
 * @description: 定义I型方块类
 * @author: xlyu
 * @create: 2019-03-13 15:31
 **/
public class I {
    Cell[] cellsI;

    /**
     * @return
     * @Param
     * @description TODO 构造器
     * @date 2019/3/13 0013 15:39
     */
    public I(int row, int col) {
        cellsI = new Cell[4];
        cellsI[0] = new Cell(row, col);
        cellsI[1] = new Cell(row + 1, col);
        cellsI[2] = new Cell(row + 2, col);
        cellsI[3] = new Cell(row + 3, col);
    }

    /**
     * @return
     * @Param
     * @description TODO 下落
     * @date 2019/3/13 0013 15:39
     */
    public void drop() {
        for (int i = 0; i < cellsI.length; i++) {
            cellsI[i].row++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 左移
     * @date 2019/3/13 0013 15:40
     */
    public void moveLeft() {
        for (int i = 0; i < cellsI.length; i++) {
            cellsI[i].col--;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 右移
     * @date 2019/3/13 0013 15:40
     */
    public void moveRight() {
        for (int i = 0; i < cellsI.length; i++) {
            cellsI[i].col++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 绘制输出面板
     * @date 2019/3/13 0013 15:41
     */
    public void printI(int totalRow, int totalCol, I i) {
        for (int row = 1; row <= totalRow; row++) {
            for (int col = 1; col <= totalCol; col++) {
                boolean iscell = false;
                for (int index = 0; index < cellsI.length; index++) {
                    if (row == cellsI[index].row && col == cellsI[index].col) {
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
     * @description TODO 获取单元格位置信息
     * @date 2019/3/13 0013 15:41
     */
    public String getIInfo() {
        String str = " ";
        for (int i = 0; i < cellsI.length; i++) {
            str += "(" + cellsI[i].row + "," + cellsI[i].col + ")";
        }
        System.out.println(str);
        return str;
    }
}
