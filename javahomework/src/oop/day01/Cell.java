/**
 * @Author xlyu
 * @Date 2019/3/11 0011
 * @Description
 */
package oop.day01;

/**
 * @program: javahomework
 * @description: 创建一个Cell类，其中包含行，列的声明，下降的方法，左移和右移的方法
 * @author: xlyu
 * @create: 2019-03-11 16:04
 **/
public class Cell {
    int row;//行
    int col;//列

    //下降
    public void drop(int i) {
        i = 1;
        row++;

    }

    //左移
    public void moveLeft(int num) {
        num = 2;
        col--;
    }

    //右移
    public void moveRight(int num2) {
        num2 = 3;
        col++;
    }

    //坐标位置展示
    public String getCellInfo() {
        return row + "," + col;
    }
}
