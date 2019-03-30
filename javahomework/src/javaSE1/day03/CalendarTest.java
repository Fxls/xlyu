/**
 * @Author xlyu
 * @Date 2019/3/28 0028
 * @Description
 */
package javaSE1.day03;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @program: javaHomework
 * @description: Calendar测试
 * @author: xlyu
 * @create: 2019-03-28 16:16
 **/
public class CalendarTest {
    @Test
    /**
     * @Param
     * @description TODO Calendar用于封装日历信息，其主要作用在于其方法可以对时间分量进行计算
     *                   Calendar是抽象类，其具体子类针对不同国家的日历系统，GregorianCalendar（阳历）
     * @date 2019/3/28 0028 16:22
     * @return void
     */
    public void test() {
        /*getInstance方法返回一个Calendar对象，其日历字段已由当前日期和时间初始化*/
        Calendar c = Calendar.getInstance();
        System.out.println(c.getClass().getName());//java.util.GregorianCalendar
        System.out.println(c.getTime());//Thu Mar 28 16:22:09 CST 2019
        /*创建GregorianCalendar---*/
        GregorianCalendar c1 = new GregorianCalendar();
        System.out.println(c1.getTime());//Thu Mar 28 16:40:37 CST 2019

        /*设置分量*/
        c1.set(Calendar.YEAR, 1997);//1997年
        c1.set(Calendar.MONTH, Calendar.DECEMBER);//12月
        c1.set(Calendar.DATE, 11);//11日
        System.out.println(c1.getTime());//Thu Dec 11 16:52:25 CST 1997
        c1.set(Calendar.DATE, 11+365);//过365天
        System.out.println(c1.getTime());//Fri Dec 11 16:52:25 CST 1998
        int dayOf = c1.get(c1.DAY_OF_MONTH);
        System.out.println(dayOf);

        /*getActualMaximum给定Calendar的时间值，返回指定日历字段可能拥有的最大值*/
        Calendar c2 = Calendar.getInstance();
        int year = 1997;
        c2.set(Calendar.YEAR, year);
        for (int i = Calendar.JANUARY; i <= Calendar.DECEMBER; i++) {
            c2.set(Calendar.MONTH, i);
            System.out.println(year + "年" + (i + 1) + "月" + c2.getActualMaximum(Calendar.DATE) + "天");
        }
    }

    @Test
    /**
     * @Param
     * @description TODO add为给定的时间分量的值加上给定的值，若给定的值是负数则是减去给定的值
     * @date 2019/3/28 0028 19:17
     * @return void
     */
    public void test2() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 5);
        c.add(Calendar.MONTH, -5);
        c.add(Calendar.DATE, -2);
        System.out.println("year--" + c.get(Calendar.YEAR));
        System.out.println("month--" + (c.get(Calendar.MONTH) + 1));
        System.out.println("day--" + c.get(Calendar.DAY_OF_MONTH));
        Date date = new Date();
        c.setTime(date);
        date = c.getTime();
        System.out.println(date);
    }
}
