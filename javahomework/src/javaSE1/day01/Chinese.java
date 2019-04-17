/**
 * @Author xlyu
 * @Date 2019/3/25 0025
 * @Description
 */
package javaSE1.day01;


/**
 * @program: javahomework
 * @description: 输出汉字--这里输出的是Unicode范围为4E00-9FA5的20902个汉字
 * @author: xlyu
 * @create: 2019-03-25 19:28
 **/
public class Chinese {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int num = 1;//用于统计字数，五十个换行
        for (char c = '\u4e00'; c <= '\u9fa5'; c++, num++) {
            sb.append(c);
            if (num % 50 == 0) {
                sb.append("\n");//回车符号-\n
            }
        }
        System.out.println(sb);
    }
}
