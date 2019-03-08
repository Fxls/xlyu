/**
 * @Author xlyu
 * @Date 2019/3/6 0006
 * @Description
 */
package basic.day05;

import java.util.Arrays;

/**
 * @program: homeworkday04
 * @description: 数组的复制
 * @author: xlyu
 * @create: 2019-03-06 19:16
 **/
public class ArrCopy {

    public static void main(String[] args) {
        int[] arr1;
        arr1 = new int[]{0, 2, 3, 4, 5, 6};
        int[] arr2;
        arr2 = new int[]{0, 0, 0, 0, 0, 0, 0};
        System.arraycopy(arr1, 1, arr2, 0, 5);
        System.out.println(Arrays.toString(arr2));
    }
}
