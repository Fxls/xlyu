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
        System.out.println("输入一个数****");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if (check(input) == false) {
            System.out.println("数字格式错误！");
        } else if (input.equals(String.valueOf(Double.parseDouble(input)))) {
            System.out.println("是小数:" + input);
        } else if (input.equals(String.valueOf(Integer.parseInt(input)))) {
            System.out.println("是整数:" + input);
        } else {
            System.out.println("未知错误");
        }

    }

    /**
     * @return
     * @Param
     * @description TODO 检测输入字符串是否为数值类型的字符串
     * @date 2019/3/27 0027 15:47
     */

    public static boolean check(String input) {
        boolean isNum = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 48 || input.charAt(i) > 57) {
                isNum = false;
            } else {
                isNum = true;
            }
        }
        return isNum;
    }
}
