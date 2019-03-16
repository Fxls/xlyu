/**
 * @Author xlyu
 * @Date 2019/3/9 0009
 * @Description
 */
package book.book02;


import javafx.scene.layout.Background;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @program: codebook
 * @description: 在窗体内生成300个❤，位置随机，颜色随机
 * @author: xlyu
 * @create: 2019-03-09 10:35
 **/
public class Star {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Star");//创建窗体
        frame.getContentPane().setBackground(Color.black);
        frame.setSize(1920, 1080);//设置窗体大小
        MyPanel mp = new MyPanel();
        frame.add(mp);
        frame.setVisible(true);
    }

    static class MyPanel extends Panel {//继承Panel

        //重绘方法
        public void paint(Graphics graphics) {
            graphics.setFont(new Font(null, 0, 90));
            for (int i = 0; i < 300; i++) {
                int x = (int) (Math.random() * 1920);
                int y = (int) (Math.random() * 1080);
                graphics.drawString("❤", x, y);
                graphics.setColor(randomColor());//画笔颜色随机
            }
        }
    }

    //生命产生随机颜色的方法
    public static Color randomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }
}
