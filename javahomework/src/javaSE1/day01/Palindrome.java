/**
 * @Author xlyu
 * @Date 2019/3/25 0025
 * @Description
 */
package javaSE1.day01;

/**
 * @program: javahomework
 * @description: 回文的判断
 * @author: xlyu
 * @create: 2019-03-25 19:15
 **/
public class Palindrome {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("able was i ere i saw elba");
        StringBuilder sb2 = sb.reverse();//reverse方法两级翻转
        if (sb2.equals(sb)) {//检查翻转后的内容是否与之前相同
            System.out.println(sb + "是回文");
        } else {
            System.out.println(sb + "不是回文");
        }
    }
}
