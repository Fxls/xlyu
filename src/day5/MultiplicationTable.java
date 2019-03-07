/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package day5;

/**
 * @program: homeworkday04
 * @description: 9*9tab
 * @author: xlyu
 * @create: 2019-03-05 20:19
 **/
public class MultiplicationTable {

    public static void main(String[] args) {

        for (int b = 1; b <= 9; b++) {
            for (int a = 1; a <= b; a++) {
                System.out.print(a + "*" + b + "=" + a * b + " ");
            }
            System.out.println();
        }
    }
}
