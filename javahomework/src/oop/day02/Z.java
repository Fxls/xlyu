/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day02;

/**
 * @program: javahomework
 * @description: 定义Z型方块类
 * @author: xlyu
 * @create: 2019-03-13 15:42
 **/
public class Z {
    Cell[] cellsZ;

    /**
     * @return
     * @Param
     * @description TODO 构造器
     * @date 2019/3/13 0013 15:39
     */
    public Z(int row, int col) {
        cellsZ = new Cell[4];
        cellsZ[0] = new Cell(row, col);
        cellsZ[1] = new Cell(row, col + 1);
        cellsZ[2] = new Cell(row + 1, col + 1);
        cellsZ[3] = new Cell(row + 1, col + 2);
    }

    /**
     * @return
     * @Param
     * @description TODO 下落
     * @date 2019/3/13 0013 15:39
     */
    public void drop() {
        for (int i = 0; i < cellsZ.length; i++) {
            cellsZ[i].row++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 左移
     * @date 2019/3/13 0013 15:40
     */
    public void moveLeft() {
        for (int i = 0; i < cellsZ.length; i++) {
            cellsZ[i].col--;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 右移
     * @date 2019/3/13 0013 15:40
     */
    public void moveRight() {
        for (int i = 0; i < cellsZ.length; i++) {
            cellsZ[i].col++;
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 绘制输出面板
     * @date 2019/3/13 0013 15:41
     */
    public void printZ(int totalRow, int totalCol, Z z) {
        for (int row = 1; row <= totalRow; row++) {
            for (int col = 1; col <= totalCol; col++) {
                boolean iscell = false;
                for (int i = 0; i < cellsZ.length; i++) {
                    if (row == cellsZ[i].row && col == cellsZ[i].col) {
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
    public String getZInfo() {
        String str = " ";
        for (int i = 0; i < cellsZ.length; i++) {
            str += "(" + cellsZ[i].row + "," + cellsZ[i].col + ")";
        }
        System.out.println(str);
        return str;
    }
}
