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
 * @description: 用线程完成窗体颜色切换功能（Runnable实现）,添加sleep方法，渐变功能添加
 * @author: xlyu
 * @create: 2019-04-09 14:43
 **/
public class FrameColorTestV3 implements Runnable {
    private JFrame jFrame;

    public FrameColorTestV3(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void run() {
        int r = 0;
        boolean increase = true; // 自增


        while (true) {
            jFrame.getContentPane().setBackground(new Color(r, 0, 0));
            if (increase) {
                r++;
            } else {
                r--;
            }

            if (r >= 255) {
                increase = false;
            }

            if (r <= 0) {
                increase = true;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Frame.Color");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 500);
        jFrame.setVisible(true);
        Thread thread = new Thread(new FrameColorTestV3(jFrame));
        thread.start();
    }
}
