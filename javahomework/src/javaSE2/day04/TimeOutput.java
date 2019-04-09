/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

import java.time.LocalDateTime;

/**
 * @program: javaHomework
 * @description: 每过五秒输出当前时间，主线程结束关闭
 * @author: xlyu
 * @create: 2019-04-09 16:59
 **/
public class TimeOutput {
    public static void main(String[] args) throws InterruptedException {
        Thread time = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
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
        time.setDaemon(true);
        time.start();
        Thread.sleep(30000);
    }
}
