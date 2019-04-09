/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

/**
 * @program: javaHomework
 * @description: 自定义线程类
 * @author: xlyu
 * @create: 2019-04-09 14:27
 **/
public class DiyThread extends Thread {

    public DiyThread() {

    }

    /**
     * 重写Thread中的run方法
     */
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + "\t");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}
