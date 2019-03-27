/**
 * @Author xlyu
 * @Date 2019/3/27 0027
 * @Description
 */
package javaSE1.day02;

import org.junit.Test;

import java.util.Scanner;

/**
 * @program: javahomework
 * @description: 第一题
 * @author: xlyu
 * @create: 2019-03-27 14:30
 **/
public class RegexTask_1 {
    public static void main(String[] args) {
        id();
        phoneNum();
        mail();
    }

    public static void id() {
        String id = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        Scanner sc = new Scanner(System.in);
        System.out.println("输入身份证号");
        String input = sc.next();
        if (input.matches(id)) {
            System.out.println("输入格式正确！！");
        } else {
            System.out.println("输入格式错误！！");
        }
    }

    public static void phoneNum() {
        String pn = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
        Scanner sc = new Scanner(System.in);
        System.out.println("输入手机号*****");
        String input = sc.next();
        if (input.matches(pn)) {
            System.out.println("手机号格式*****");
        } else {
            System.out.println("手机号格式错误");
        }
    }

    public static void mail() {
        String mail = "^[1-9]\\d{5}$";
        Scanner sc = new Scanner(System.in);
        System.out.println("输入邮编*****");
        String input = sc.next();
        sc.close();
        if (input.matches(mail)) {
            System.out.println("邮编格式正确*****");
        } else {
            System.out.println("邮编格式错误");
        }
    }
}
