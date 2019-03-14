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
}