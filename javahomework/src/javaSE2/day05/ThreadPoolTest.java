/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: javaHomework
 * @description: 线程池测试
 * @author: xlyu
 * @create: 2019-04-10 10:57
 **/
public class ThreadPoolTest {


    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        };

        //创建固定线程池
        ExecutorService es = Executors.newFixedThreadPool(2);

        //循环执行五次任务
        for (int i = 0; i < 5; i++) {

            ///submit向线程池分配任务
            es.submit(task);
        }

        //关闭线程池
        es.shutdown();
    }
}
