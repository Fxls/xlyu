/**
 * @Author xlyu
 * @Date 2019/3/13 0013
 * @Description
 */
package oop.day03;

/**
 * @program: javahomework
 * @description: 控制台
 * @author: xlyu
 * @create: 2019-03-13 20:14
 **/
public class TetrominoGame {
    public static void main(String[] args) {
        System.out.println("****打印T型****");
        Tetromino t = new TetrominoT(3, 3);
        print(t);
        System.out.println("****打印J型****");
        Tetromino j = new TetrominoJ(3, 3);
        print(j);
    }

    public static void print(Tetromino tetromino) {
//        Cell[] cells = tetromino.cells;
        int totalRow = 10;
        int totalCol = 15;
        for (int row = 1; row <= totalRow; row++) {
            for (int col = 1; col <= totalCol; col++) {
                boolean iscell = false;
                for (int index = 0; index < tetromino.cells.length; index++) {
                    if (tetromino.cells[index].row == row && tetromino.cells[index].col == col) {
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
}
