/**
 * @Author xlyu
 * @Date 2019/3/7 0007
 * @Description
 */
package book.book01;

import java.util.Arrays;

/**
 * @program: document3.6
 * @description: 输出一个随机数组，并计算这个数组中元素的平均数
 * @author: xlyu
 * @create: 2019-03-07 14:15
 **/
public class ArrAverage {
    public static void main(String[] args) {
        int length = (int) (Math.random() * 20 + 1);
        int[] arr = new int[length];
//        利用一个for循环对数组内的元素随机赋值（0~100）
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println("该数组为：" + Arrays.toString(arr));
//        利用for循环实现数组元素累加
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("该数组中元素的平均数为：" + (sum / arr.length));
    }
}
