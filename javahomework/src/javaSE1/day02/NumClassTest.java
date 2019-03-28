/**
 * @Author xlyu
 * @Date 2019/3/27 0027
 * @Description
 */
package javaSE1.day02;

import org.junit.Test;

/**
 * @program: javahomework
 * @description: 包装类的方法测试
 * @author: xlyu
 * @create: 2019-03-27 18:52
 **/
public class NumClassTest {
    @Test
    public void testParse() {
        int i = Integer.parseInt("165");
        double d = Double.parseDouble("16.5");
        double d2 = Double.parseDouble("165");//小转大
        System.out.println(i);
        System.out.println(d);
        System.out.println(d2);
    }

    @Test
    public void test() {
        Number n = 15.0;
        System.out.println(n.doubleValue());
        System.out.println(n.longValue());
        System.out.println(((Double) n).parseDouble("95"));
    }
}
