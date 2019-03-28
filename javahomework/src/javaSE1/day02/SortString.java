/**
 * @Author xlyu
 * @Date 2019/3/27 0027
 * @Description
 */
package javaSE1.day02;


/**
 * @program: javaHomework
 * @description: 统计字符串中某个字符重复个数
 * @author: xlyu
 * @create: 2019-03-27 18:58
 **/
public class SortString {
    public static void main(String[] args) {
        check_a_String();
    }

    public static void check_a_String() {
        String str = "flringonfaidbngdurgirgongoeig";
        String str2 = str.replace("g","");
        System.out.println(str.length()-str2.length());
    }
}
