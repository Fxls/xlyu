/**
 * @Author xlyu
 * @Date 2019/3/28 0028
 * @Description
 */
package javaSE1.day03;

import org.junit.Test;

import java.util.Date;

/**
 * @program: javaHomework
 * @description: Date测试
 * @author: xlyu
 * @create: 2019-03-28 15:34
 **/
public class DateTest {
    @Test
    public void date() {
        Date date = new Date();
        /*打印现在的时间（程序当前运行的时间）*/
        System.out.println(date);//Thu Mar 28 15:40:15 CST 2019
        /*long一个time来接收70.1.1到现在的毫秒数，类似于System.currentTimeMillis();*/
        long time = date.getTime();
        System.out.println(time);//1553758898965
        /*一个小时后*/
        time = time + 60 * 60 * 1000;//单位是ms
        /*设置date，此时date的时间已经过去了一个小时所对应的ms数*/
        date.setTime(time);
        System.out.println(date);//Thu Mar 28 16:46:26 CST 2019
    }

}
