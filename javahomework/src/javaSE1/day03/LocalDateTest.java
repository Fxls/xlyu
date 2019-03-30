/**
 * @Author xlyu
 * @Date 2019/3/30
 * @Description
 */
package javaSE1.day03;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

/**
 * @program: javaHomework
 * @description: LocalDate测试
 * @author: xlyu
 * @create: 2019-03-30 09:51
 **/
public class LocalDateTest {
    @Test
    public void test() {
        /*LocalDate类与LocalTime很类似，获取当前日期*/
        LocalDate ld = LocalDate.now();
        System.out.println(ld);//2019-03-30

        /*自行设置日期,year,month,dayOfMonth*/
        LocalDate ld2 = LocalDate.of(1997, 12, 11);
        System.out.println(ld2);//1997-12-11
    }

    @Test
    public void test2() {
        LocalDate ld = LocalDate.now();
        /*get方法获取具体的日期分量，使用时注意返回类型*/
        int year = ld.getYear();
        int month = ld.getMonthValue();
        int dayOfMonth = ld.getDayOfMonth();
        String dayOfWeekStr = ld.getDayOfWeek().toString();
        int dayOfYear = ld.getDayOfYear();
        System.out.println(year);//2019
        System.out.println(month);//3
        System.out.println(dayOfMonth);//30
        System.out.println(dayOfWeekStr);//SATURDAY
        System.out.println(dayOfYear);//89
    }

    @Test
    public void test3() {
        /*plus方法，与LocalTime中基本相似*/
        LocalDate ld = LocalDate.of(2015, 9, 1);
        String ld_plus = ld.plusYears(4).plusMonths(1).plusDays(20).plusWeeks(1).toString();
        System.out.println(ld_plus);//2019-10-28
    }

    @Test
    public void test4() {
        /*minus方法，与LocalTime中基本相似*/
        LocalDate ld = LocalDate.of(2019, 10, 28);
        String ld_minus = ld.minusYears(4).minusMonths(1).minusDays(20).minusWeeks(1).toString();
        System.out.println(ld_minus);//2015-09-01
    }

    @Test
    public void test5() {
        /*with方法，与LocalTime中基本相似*/
        LocalDate ld = LocalDate.now().withYear(1997).withMonth(12).withDayOfMonth(11);
        System.out.println(ld);
    }

    @Test
    public void test6() {
        /*与LocalTime中基本相似*/
        LocalDate ld = LocalDate.parse("2019-06-01");
        System.out.println(ld);
    }
}
