/**
 * @Author xlyu
 * @Date 2019/3/4 0004
 * @Description
 */
package homeworkday02;

/**
 * @program: nycode01
 * @description: 通过代码计算一段程序运行的时间
 * @author: xlyu
 * @create: 2019-03-04 19:12
 **/
public class Time {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();//计算时间的currentTimeMillis-（ms）
        long n = 0;//加入while语句，这段不加的话start-end=0，这段语句就是测试时间的主体程序
        while (n < 1000000000) {
            n++;
        }
        System.out.print("运行时间为：");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
