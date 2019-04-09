/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

/**
 * @program: javaHomework
 * @description: 自定义实现Runnable接口
 * @author: xlyu
 * @create: 2019-04-09 14:33
 **/
public class DiyRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 100, count = 1; i >= 1; i--, count++) {
            System.out.print(i + "\t");
            if (count % 10 == 0) {
                System.out.println();
            }
        }
    }
}
