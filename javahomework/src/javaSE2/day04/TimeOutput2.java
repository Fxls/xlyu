/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

import java.time.LocalDateTime;

/**
 * @program: javaHomework
 * @description: 每过五秒输出当前时间，主线程结束关闭（join）
 * @author: xlyu
 * @create: 2019-04-09 17:48
 **/
public class TimeOutput2 {
    public static void main(String[] args) {
        Thread time = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 6; i++) {
                    LocalDateTime ldt = LocalDateTime.now();
                    System.out.println(ldt);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    time.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("主程序运行完毕！");
            }
        });
        time.start();
        main.start();
    }
}
