/**
 * @Author xlyu
 * @Date 2019/3/9 0009
 * @Description
 */
package oop.day01;

/**
 * @program: javahomework
 * @description:Cell引用类型变量
 * @author: xlyu
 * @create: 2019-03-09 15:30
 **/
public class CellTset {
    public static void main(String[] args) {
        Cell c = new Cell();
        c.row = 1;
        c.col = 3;
        c.drop();
        c.moveLeft(2);
        //???????????? String str = c.getCellInfo();
        System.out.println(c.col);


    }

    static class Cell {


        int row;
        int col;

        public static void drop() {
            System.out.println("java");
        }

        public static int[] moveLeft(int n) {
            int[] arr = new int[n];
            return arr;
        }

    }
}
