/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

/**
 * @program: javaHomework
 * @description: 创建线程的测试
 * @author: xlyu
 * @create: 2019-04-09 14:26
 **/
public class CreateThreadTest {
    public static void main(String[] args) {

        //1、自定义线程类实现线程创建
        Thread th = new DiyThread();
        th.start();

        //2、自定义类实现Runnable接口，并重写其中的run方法
        Thread th2 = new Thread(new DiyRunnable());
        th2.start();
        //3、匿名内部类创建线程
        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i <= 100; i++) {
                    System.out.print("Q" + "\t");
                    if (i % 10 == 0) {
                        System.out.println();
                    }
                }
            }
        });
        th3.start();
    }
}
