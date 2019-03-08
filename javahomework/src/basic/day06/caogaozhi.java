/**
 * @Author xlyu
 * @Date 2019/3/8 0008
 * @Description
 */
package basic.day06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-08 12:55
 **/
public class caogaozhi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入五个字母（要求大写）：");
        String input = scanner.next();

        char[] input2 = input.toCharArray(); //将str字符串转换为字符数组
        System.out.println(Arrays.toString(input2));
    }
}
