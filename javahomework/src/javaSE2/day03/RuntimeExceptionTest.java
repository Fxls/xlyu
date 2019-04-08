/**
 * @Author xlyu
 * @Date 2019/4/8
 * @Description
 */
package javaSE2.day03;

import javaSE2.day02.Emp;
import org.junit.Test;

import java.text.SimpleDateFormat;

/**
 * @program: javaHomework
 * @description: 常见RuntimeException测试
 * @author: xlyu
 * @create: 2019-04-08 17:39
 **/
public class RuntimeExceptionTest {

    /**
     * 传入不合法或不正确参数时
     */
    @Test
    public void illegalArgumentExceptionTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = "2001-1-2";
        sdf.format(date);
        /**
         * java.lang.IllegalArgumentException: Cannot format given Object as a Date
         *
         * 	at java.text.DateFormat.format(DateFormat.java:310)
         * 	at java.text.Format.format(Format.java:157)
         * 	at javaSE2.day03.RuntimeExceptionTest.illegalArgumentExceptionTest(RuntimeExceptionTest.java:26)
         */

    }

    /**
     * 空指针异常
     */
    @Test
    public void nullPointerExceptionTest() {
        Emp emp = null;
        emp.toString();
        /**
         * java.lang.NullPointerException
         * 	at javaSE2.day03.RuntimeExceptionTest.nullPointerExceptionTest(RuntimeExceptionTest.java:27)
         */
    }

    /**
     * 数组越界，继承与IndexOutOfBoundsException
     */
    @Test
    public void arrayIndexOutOfBoundsExceptionTest() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr[100]);
        /**
         * java.lang.ArrayIndexOutOfBoundsException: 100
         *
         * 	at javaSE2.day03.RuntimeExceptionTest.arrayIndexOutOfBoundsExceptionTest(RuntimeExceptionTest.java:37)
         */
    }

    /**
     * 强转时会遇见，类型不匹配
     */
    @Test
    public void classCastExceptionTest() {
        Object o = new String();
        o = "123";
        System.out.println((Integer) o);
        /**
         * java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
         *
         * 	at javaSE2.day03.RuntimeExceptionTest.classCastExceptionTest(RuntimeExceptionTest.java:71)
         */
    }

    /**
     * 继承于IllegalArgumentException,字符串非法转换成数值型
     */
    @Test
    public void numberFormatExceptionTest() {
        String s = null;
        Integer integer = Integer.parseInt(s);
        /**
         * java.lang.NumberFormatException: null
         *
         * 	at java.lang.Integer.parseInt(Integer.java:542)
         * 	at java.lang.Integer.parseInt(Integer.java:615)
         * 	at javaSE2.day03.RuntimeExceptionTest.numberFormatExceptionTest(RuntimeExceptionTest.java:87)
         */
    }
}
