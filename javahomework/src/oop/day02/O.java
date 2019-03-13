/**
 * @Author xlyu
 * @Date 2019/3/12 0012
 * @Description
 */
package oop.day02;

/**
 * @program: javaHomework
 * @description: 定义“田”字类型方块类
 * @author: xlyu
 * @create: 2019-03-12 16:20
 **/
public class O {
    //    Cell cell = new Cell(3, 3);//第一个方块的坐标
    Cell[] cellsO;

    /**
     * 构造方法
     */
    public O(int row, int col) {
        cellsO = new Cell[4];
        cellsO[0] = new Cell(row, col);//左上角方块
        cellsO[1] = new Cell(row, col + 1);//右上角方块
        cellsO[2] = new Cell(row + 1, col);//左下角方块
        cellsO[3] = new Cell(row + 1, col + 1);//右下角方块
    }

    /**
     * 下落
     */
    public void drop(int input) {
        for (int i = 0; i < cellsO.length; i++) {
            cellsO[i].row++;
        }
    }

    /**
     * 左移
     */
    public void moveLeft(int input) {
        for (int i = 0; i < cellsO.length; i++) {
            cellsO[i].col--;
        }
    }

    /**
     * 右移一格
     */
    public void moveRight(int input) {
        for (int i = 0; i < cellsO.length; i++) {
            cellsO[i].col++;
        }
    }

    /**
     * 打印位置信息的方法
     */
    public void getOInfo() {
        String str = " ";
        for (int i = 0; i < cellsO.length; i++) {
            str += "(" + cellsO[i].row + "," + cellsO[i].col + ")";
        }
        System.out.println(str);
    }

    /**
     * 创建田字方块的绘制方法
     */
    public void printO(O o) {
        /**单元格的总数*/
        int totalRow = 10;
        int totalCol = 15;
        for (int row = 1; row <= totalRow; row++) {
            for (int col = 1; col <= totalCol; col++) {
                boolean iscells = false;
                for (int i = 0; i < cellsO.length; i++) {
                    if (row == cellsO[i].row && col == cellsO[i].col) {
                        iscells = true;
                    }
                }
                if (iscells == true) {
                    System.out.print("*" + "\t");
                } else {
                    System.out.print("-" + "\t");
                }
            }
            System.out.println(row);//输出行数
        }
        for (int col = 1; col <= totalCol; col++) {
            System.out.print(col + "\t");//输出列数
        }
        System.out.println();
    }

}
