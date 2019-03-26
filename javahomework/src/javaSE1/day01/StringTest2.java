/**
 * @Author xlyu
 * @Date 2019/3/25 0025
 * @Description
 */
package javaSE1.day01;

/**
 * @program: javahomework
 * @description: 字符串测试2
 * <p>
 * 特例
 * @author: xlyu
 * @create: 2019-03-25 15:09
 **/
public class StringTest2 {
    private static final String A = "ab";
    private static final String B = "cd";

    public static void main(String[] args) {
        String s = A + B;
        String t = "abcd";
        if (s == t) {
            System.out.println("同一个对象");
        } else {
            System.out.println("不是同一个对象");
        }

        //输出结果：同一个对象。因为AB都是常量，所以s的值是固定的，也就是String s = A + B;等同于String = "ab" + "cd";
    }
}
