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
    Cell cell = new Cell(3, 3);
    Cell[] cells;

    /**
     * 初始化cells属性
     */
    public O() {
        this(0, 0);
    }

    /**
     * 构造方法重载
     */
    public O(int row, int col) {
        cells = new Cell[4];
        cells[0] = new Cell(row, col);//左上角方块
        cells[1] = new Cell(row, col + 1);//右上角方块
        cells[2] = new Cell(row + 1, col);//左下角方块
        cells[3] = new Cell(row + 1, col + 1);//右下角方块
    }

    /**
     * 下落
     */
    public void drop(int input) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].row++;
        }
    }

    /**
     * 左移
     */
    public void moveLeft(int input) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].col--;
        }
    }

    /**
     * 右移一格
     */
    public void moveRight(int input) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].col++;
        }
    }

    /**
     * 打印位置信息的方法
     */
    public void getOInfo() {
        String str = " ";
        for (int i = 0; i < cells.length; i++) {
            str += "(" + cells[i].row + "," + cells[i].col + ")";
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
                /**满足这四个的任意一个条件都打印*，其余的同day01.cell3的写法*/
                if ((cells[1].row == row && cells[1].col == col) ||
                        (cells[0].row == row && cells[0].col == col) ||
                        (cells[2].row == row && cells[2].col == col) ||
                        (cells[3].row == row && cells[3].col == col)) {
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
