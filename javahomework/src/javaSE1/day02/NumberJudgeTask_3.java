/**
 * @Author xlyu
 * @Date 2019/3/27 0027
 * @Description
 */
package javaSE1.day02;

import java.util.Scanner;

/**
 * @program: javaHomework
 * @description: 作业第三题
 * @author: xlyu
 * @create: 2019-03-27 14:47
 **/
public class NumberJudgeTask_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String integerNum = "[1-9]?[0-9]+";
        String doubleNum = "[0-9]+\\.[0-9]+";
        String notNum = "^(([1-9]?[0-9]+)&([0-9]+\\.[0-9]+))";
        if (input.matches(integerNum)) {
            System.out.println("这是整数：" + input);
        } else if (input.matches(doubleNum)) {
            System.out.println("这是小数：" + input);
        } else {
            System.out.println("这不是一个数！");
        }
    }
}
