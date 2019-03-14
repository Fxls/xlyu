/**
 * @Author xlyu
 * @Date 2019/3/12 0012
 * @Description
 */
package oop.day03;

/**
 * @program: javahomework
 * @description: 1、在原有的Cell类基础上，重载上移，左移，右移方法
 * 2、给Cell添加构造方法
 * 3、给Cell重载构造方法
 * @author: xlyu
 * @create: 2019-03-12 14:46
 **/
public class Cell {
    int row;
    int col;

    /**
     * 第一次次构造的目的：初始化
     */
    public Cell() {
        this.row = 0;
        this.col = 0;
    }

    /**
     * 使用this关键字重构
     */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * 下落方法
     */
    public void drop() {
        row++;
    }

    /**
     * 重载下落方法
     */
    public void drop(int input) {
        row++;
    }

    /**
     * 左移方法
     */
    public void moveLeft() {
        col--;
    }

    /**
     * 重载左移方法
     */
    public void moveLeft(int input) {
        col--;
    }

    /**
     * 右移方法
     */
    public void moveRight() {
        col++;
    }
    /**
     * 重载右移方法
     */
    public void moveRight(int input) {
        col++;
    }

    /**
     * 绘制方法
     */
    public void printCell(Cell cell) {
        int totalRow = 20;
        int totalCol = 15;
        for (int row = 1; row <= totalRow; row++) {
            for (int col = 1; col <= totalCol; col++) {
                if (row == cell.row && col == cell.col) {
                    System.out.print("*" + "\t");
                } else {
                    System.out.print("-" + "\t");
                }
            }
            System.out.println(row);//显示行数
        }
        for (int i = 1; i <= totalCol; i++) {
            System.out.print(i + "\t");//显示列数
        }
        System.out.println();
    }

    /**
     * 获取位置信息
     */
    public String getCellInfo() {
        return "(" + row + "," + col + ")";
    }
}
