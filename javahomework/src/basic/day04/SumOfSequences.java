/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package basic.day04;

/**
 * @program: homeworkday04
 * @description: 9+99+999+...+9999999999=？
 * @author: xlyu
 * @create: 2019-03-05 19:05
 **/
public class SumOfSequences {
    public static void main(String[] args) {
        long n = 0L;
        long j = 1l;
        for (long i = 1L; i <= 10; i++) {
            j = j * 10;
            n = n + j - 1;

        }
        System.out.println(n);
    }
}


