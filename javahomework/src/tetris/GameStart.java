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
    public static final int WEIGHT = 530;
    public static final int HEIGHT = 570;

    public static void main(String[] args) {
        GameStart gameStart = new GameStart();
        gameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameStart.setSize(WEIGHT, HEIGHT);
        gameStart.setTitle("俄罗斯方块");
        gameStart.setResizable(false);
        gameStart.add(new Tetris());
        gameStart.setVisible(true);
    }
}
