/**
 * @Author xlyu
 * @Date 2019/4/2
 * @Description
 */
package javaSE1.day04;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: javaHomework
 * @description: Task08
 * @author: xlyu
 * @create: 2019-04-02 10:18
 **/
public class DequeTest {
    @Test
    /**
     * Deque是Queue的子接口，可以实现元素两端的操作，这里是对队列进行测试
     */
    public void test() {
        Deque<String> dq = new LinkedList<>();
        /*offer：向队列尾部添加元素*/
        dq.offer("123");
        dq.offer("456");
        dq.offer("789");
        dq.offer("000");
        dq.offer("***");
        System.out.println(dq);//[123, 456, 789, 000, ***]

        /*poll：获取队列头部元素，并从队列中删除*/
        dq.poll();
        System.out.println(dq);//[456, 789, 000, ***],可以发现，队列是先进先出FIFO
    }

    @Test
    /**
     * 对栈进行测试。
     */
    public void test2() {
        Deque<String> deque = new LinkedList<>();
        /*push:进栈*/
        deque.push("1");
        deque.push("2");
        deque.push("3");
        deque.push("4");
        deque.push("5");
        System.out.println(deque);//[5, 4, 3, 2, 1]

        /*pop：出栈*/
        deque.pop();
        System.out.println(deque);//[4, 3, 2, 1],后进先出LIFO
    }
}
