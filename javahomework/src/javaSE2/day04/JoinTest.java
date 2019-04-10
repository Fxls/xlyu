/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: javaHomework
 * @description: join测试
 * @author: xlyu
 * @create: 2019-04-09 16:20
 **/
public class JoinTest {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("资源加载： " + i + "%");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("资源加载完成！");
            }
        });
        t.start();
        t2.start();
    }
}
