/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

/**
 * @program: javaHomework
 * @description: 线程类API测试
 * @author: xlyu
 * @create: 2019-04-09 14:55
 **/
public class ThreadAPITest {
    public static void main(String[] args) {

        Thread th = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
            }

            //1、currentThread
            Thread currentThread = Thread.currentThread();
            System.out.println("ct:" + currentThread);
        });

        //2、getID
        long id = th.getId();
        System.out.println("id:" + id);

        //3、getName
        String name = th.getName();
        System.out.println("name:" + name);

        //5、setName
        th.setName("change name");

        //3、getName
        String nameChange = th.getName();
        System.out.println("name:" + nameChange);

        //4、getPriority
        int pri = th.getPriority();
        System.out.println("优先级：" + pri);

        //start进入就绪状态
        th.start();

        /**
         * 打印结果
         *      id:11
         *      name:Thread-0
         *      name:change name
         *      优先级：5
         *      ct:Thread[change name,5,main]
         */
    }
}
