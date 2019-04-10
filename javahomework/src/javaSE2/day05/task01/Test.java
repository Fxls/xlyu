/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day05.task01;

/**
 * @program: javaHomework
 * @description: 测试
 * @author: xlyu
 * @create: 2019-04-10 17:35
 **/
public class Test {
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(new Number(lock)).start();
        new Thread(new Character(lock)).start();

    }


}
