/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

/**
 * @program: javaHomework
 * @description: getName&getID&setName测试
 * @author: xlyu
 * @create: 2019-04-09 15:19
 **/
public class NameAndIDTest implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new NameAndIDTest());
        Thread th2 = new Thread(new NameAndIDTest());
        Thread th3 = new Thread(() -> {
        });
        th3.setName("name changed");
        System.out.println("1-n:" + th1.getName());//1-n:Thread-0
        System.out.println("1-i:" + th1.getId());//1-i:11
        System.out.println("2-n:" + th2.getName());//2-n:Thread-1
        System.out.println("2-i:" + th2.getId());//2-i:12
        System.out.println("3-n:" + th3.getName());//3-n:name changed
        System.out.println("3-i:" + th3.getId());//3-i:13
        th1.start();
        th2.start();
        th3.start();
    }
}
