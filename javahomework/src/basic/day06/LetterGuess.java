/**
 * @Author xlyu
 * @Date 2019/3/8 0008
 * @Description
 */
package basic.day06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @program: javahomework
 * @description: 猜字母游戏V1.0(弱智版本)
 * 随机生成五个字母，用户数输入五个字母，系统提示输入正确的个数，并提示正确字母
 * 所在的位置，输出答案，进行验算观察
 * @author: xlyu
 * @create: 2019-03-08 11:56
 **/
public class LetterGuess {
    public static void main(String[] args) {
        //创建一个长度为5的字符型数组
        char[] arr = new char[5];

        //建立一个for循环对arr中的元素随机赋值
        for (int i = 0; i < arr.length; i++) {

            //对arr中元素赋值，A~Z对应为[65~90]
            arr[i] = (char) (Math.random() * 26 + 65);
        }

        //控制台界面用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入五个字母（要求大写）：");
        String input = scanner.next();
        scanner.close();

        //因为字符串类型无法和字符类型进行对等操做，这里我把str字符串转换为字符数组
        //然后再拿转化后的字符数组中的元素与原数组比较
        char[] arr2 = input.toCharArray();
        //for循环，依次提取新数组中arr中的元素进行比较
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            //如果=，则分数加1
            if (arr2[i] == arr[i]) {
                count++;
                System.out.println(arr2[i] + "在第" + (i + 1) + "位！得" + count + "分！");
            }
        }
        System.out.println("您全部猜错！下次努力");
        System.out.println("答案是：" + Arrays.toString(arr));//输出答案让用户进行比对
    }
}

