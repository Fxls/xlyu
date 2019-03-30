/**
 * @Author xlyu
 * @Date 2019/3/30
 * @Description
 */
package javaSE1.day03;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @program: javaHomework
 * @description: LocalTime测试
 * @author: xlyu
 * @create: 2019-03-30 08:52
 **/
public class LocalTimeTest {

    @Test
    /**
     * @return
     * @Param
     * @description LocalTime是final修饰的，无法被继承,LocalTime的构造器是private修饰的
     * 无法通过new实例化，这一点需要注意
     * @date 2019/3/30 8:54
     */
    public void test() {
        /*获取当下的时间*/
        LocalTime lt = LocalTime.now();
        String ltStr = lt.toString();//声明一个ltStr来接收lt的toString结果，LocalTime中重写了toString
        System.out.println(ltStr);//09:12:21.755

        /*自定义时间*/
        LocalTime lt2 = LocalTime.of(12, 00, 01);//四个参数，具体填写看具体情况，如果second是00，系统会自懂省略
        System.out.println(lt2);//12:00:01
    }

    @Test
    public void test2() {
        LocalTime lt = LocalTime.now();

        /*获取时间分量，返回类型都是int型*/
        int h = lt.getHour();
        int m = lt.getMinute();
        int s = lt.getSecond();
        int n = lt.getNano();
        System.out.println(h + "*" + m + "*" + s + "*" + n);//9*23*49*195000000
    }

    @Test
    public void test3() {
        LocalTime lt = LocalTime.of(20, 25, 30, 15000);
        /*增加时间分量的方法plus，返回对象仍是LocalTime，所以可以级联调用*/
        LocalTime lt_plus = lt.plusHours(2).plusMinutes(15).plusSeconds(10);

        System.out.println(lt);//20:25:30.000015
        System.out.println(lt_plus);//22:40:40.000015
    }

    @Test
    public void test4() {
        LocalTime lt = LocalTime.of(22, 40, 40, 15000);
        /*减少时间分量的方法minus与plus类似*/
        LocalTime lt_minus = lt.minusHours(2).minusMinutes(15).minusSeconds(10);

        System.out.println(lt);//22:40:40.000015
        System.out.println(lt_minus);//20:25:30.000015
    }

    @Test
    public void test5() {
        /*withHour等方法，重设时间分量*/
        LocalTime lt = LocalTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);//00:00
        System.out.println(lt);
    }

    @Test
    public void test6() {
        /*parse用法和其他类中基本一样，输入格式一定要匹配，否则会报错-java.time.format.DateTimeParseException*/
        LocalTime lt = LocalTime.parse("09:45:04");
        System.out.println(lt);
    }

    @Test
    /**
     * @Param
     * @description 标准时间的表示
     * @date 2019/3/30 9:48
     * @return
     */
    public void test7() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);//2019-03-30T09:50:08.658
    }
}
