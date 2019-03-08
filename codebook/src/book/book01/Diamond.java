/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package book.book01;

/**
 * @program: homeworkday04
 * @description: for循环打印菱形
 * @author: xlyu
 * @create: 2019-03-05 20:17
 **/
public class Diamond {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {//行数设置：5行
            for (int j = 4; j > i; j--) {//空格设置
                System.out.print(" ");
            }
            for (int k = 0; k < i * 2 + 1; k++) {
                System.out.print(".");
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) {
            for (int j = -1; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 7 - i * 2; k++) {
                System.out.print(".");
            }
            System.out.println();
        }

    }
}
