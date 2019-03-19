/**
 * @Author xlyu
 * @Date 2019/3/19 0019
 * @Description
 */
package tetris;

import tetris.view.Tetris;

import javax.swing.*;

/**
 * @program: javaHomework
 * @description: 游戏入口
 * @author: xlyu
 * @create: 2019-03-19 08:40
 **/
public class GameStart extends JFrame {
    //设置窗口规格的静态变量
    public static final int WEIGHT = 530;
    public static final int HEIGHT = 570;

    public static void main(String[] args) {
        GameStart gameStart = new GameStart();
        gameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//开关设置
        gameStart.setSize(WEIGHT, HEIGHT);
        gameStart.setTitle("俄罗斯方块");
        gameStart.setResizable(false);
        gameStart.add(new Tetris());//添加继承JPanel的子类画布
        gameStart.setVisible(true);//窗体可视化
    }
}
