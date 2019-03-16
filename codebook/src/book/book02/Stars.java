/**
 * @Author xlyu
 * @Date 2019/3/15 0015
 * @Description
 */
package book.book02;

import javax.swing.*;
import java.awt.*;


/**
 * @program: codebook
 * @description: 闪烁星星的实现
 * @author: xlyu
 * @create: 2019-03-15 20:17
 **/
public class Stars extends JFrame {
    public Stars() {
        MyPanel myPanel = new MyPanel();
        myPanel.setBackground(Color.black);
        this.setSize(1920, 1080);
        this.getContentPane().setBackground(Color.black);
        this.setTitle("闪烁星星");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        Thread t = new Thread(myPanel);
        t.start();
        Container cn = this.getContentPane();//容器
        cn.add(myPanel);
    }

    public static void main(String[] args) {
        Stars stars = new Stars();
    }

}

class MyPanel extends JPanel implements Runnable {
    final int count = 100;
    int[] x = new int[count];
    int[] y = new int[count];
    Color[] c = new Color[400];

    public MyPanel() {
        for (int i = 0; i < count; i++) {
            x[i] = (int) (Math.random() * 1920);
            y[i] = (int) (Math.random() * 1020);
        }
        for (int i = 0; i < 400; i++) {
            c[i] = new Color((int) (Math.random() * 0xffffff));
        }
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, 1920, 1080);//清除
        for (int i = 0; i < count; i++) {
            g.setColor(c[i]);
            if ((int) (Math.random() * 400) != 0) {
                g.setFont(new Font("", Font.BOLD, 60));
                g.drawString("⭐", x[i], y[i]);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (Exception e) {
            }
            this.repaint();
        }
    }
}
