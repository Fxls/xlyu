/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day04;

/**
 * @program: javaHomework
 * @description: wait——notify测试
 * @author: xlyu
 * @create: 2019-04-10 14:37
 **/
public class WaitNotifyTest {

    /**
     * wait、notify都是object类中的
     * 使用wait、notify，要使用synchronized关键字实现同步
     *
     * @param args
     */
    public static void main(String[] args) {
        Object lock = new Object();

        //下载的线程
        Thread download = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 1; i <= 100; i++) {
                    System.out.println("download:" + i + "%");
                }
                System.out.println("download over!");

                //唤醒阻塞线程
                synchronized (lock) {
                    lock.notify();
                }

            }
        });

        //显示图片的线程
        Thread view = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //阻塞线程
                    synchronized (lock) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("this is your download!");
            }
        }
        );
        download.start();
        view.start();
    }
}
