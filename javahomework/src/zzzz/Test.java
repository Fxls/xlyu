/**
 * @Author xlyu
 * @Date 2019/3/22 0022
 * @Description
 */
package zzzz;

/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-22 15:39
 **/
public class Test {
    public static void main(String[] args) {
        String st1 = "abc";
        String st2 = "def";
        //输出对应索引下表下的字符
        st1.charAt(1);
        //字符串的拼接
        st1.concat(st2);
        st2.compareTo(st1);
        System.out.println(st1.charAt(1));
        System.out.println(st2.compareTo(st2));
        System.out.println(st1.concat(st2));

    }
}
