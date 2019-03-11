/**
 * @Author xlyu
 * @Date 2019/3/11 0011
 * @Description
 */
package oop.day01;

/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-11 16:13
 **/
public class Cell2 {
    public static void main(String[] args) {
        Cell cell = new Cell();
        cell.row = 15;//*所在的行数
        cell.col = 6;//*所在的列数
        cell.moveRight(1);
        cell.getCellInfo();
        printCell(cell);
    }

    public static void printCell(Cell cell) {
        int totalRow = 20;
        int totalCol = 10;
        for (int row = 1; row <= totalRow; row++) {
            for (int col = 1; col <= totalCol; col++) {
                if (cell.row == row && cell.col == col) {
                    System.out.print("*" + "\t");
                } else {
                    System.out.print("-" + "\t");
                }
            }
            System.out.println(row);
        }
        for (int i = 1; i <= totalCol; i++) {
            System.out.print(i + "\t");
        }

    }
}
