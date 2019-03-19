/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day06.shootGame;

import javax.swing.*;
import java.awt.*;

/**
 * @program: javahomework
 * @description: 界面
 * @author: xlyu
 * @create: 2019-03-18 19:48
 **/
public class Frame {
    public static void main(String[] args) {
        MyPanel myPanel = new MyPanel();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.white);
        f.setTitle("Shoot Game");
        f.setSize(600, 800);
        f.setVisible(true);
        f.add(myPanel);
    }
}

class MyPanel extends JPanel {
    public MyPanel() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("", Font.BOLD, 50));
        g.drawLine(0, 700, 600, 700);
    }
}
