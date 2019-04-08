/**
 * @Author xlyu
 * @Date 2019/4/8
 * @Description
 */
package javaSE2.day03;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: javaHomework
 * @description:
 * @author: xlyu
 * @create: 2019-04-08 19:39
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(test());
    }

    private static int test() {
        int b = 20;
        try {
            System.out.println("try block");
            b = b / 0;
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
            b += 15;
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25,b=" + b);
            }
            b += 50;
        }
        return b;
    }


}
