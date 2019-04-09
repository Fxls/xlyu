/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

/**
 * @program: javaHomework
 * @description: 守护线程测试
 * @author: xlyu
 * @create: 2019-04-09 15:29
 **/
public class DaemonTest {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(() -> {
            while (true) {
                System.out.println("后台线程");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //设置d为守护线程，当线程中只有守护线程时，强制终止所有守护线程
        d.setDaemon(true);
        d.start();
        Thread.sleep(5000);
        System.out.println("main线程结束");
    }
}
