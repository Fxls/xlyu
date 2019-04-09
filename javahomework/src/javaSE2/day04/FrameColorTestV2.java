/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

import javax.swing.*;
import java.awt.*;

/**
 * @program: javaHomework
 * @description: 用线程完成窗体颜色黑白切换功能（Runnable实现）,添加sleep方法
 * @author: xlyu
 * @create: 2019-04-09 14:43
 **/
public class FrameColorTestV2 implements Runnable {
    private JFrame jFrame;

    public FrameColorTestV2(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void run() {
        boolean b = true;
        while (true) {
            if (b) {
                jFrame.getContentPane().setBackground(Color.black);
            } else {
                jFrame.getContentPane().setBackground(Color.white);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b = !b;
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Frame.Color");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 500);
        jFrame.setVisible(true);
        Thread thread = new Thread(new FrameColorTestV2(jFrame));
        thread.start();
    }
}
