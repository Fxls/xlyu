/**
 * @Author xlyu
 * @Date 2019/3/9 0009
 * @Description
 */
package book.book01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: codebook
 * @description: 猜字母游戏
 * @author: xlyu
 * @create: 2019-03-09 08:51
 **/
/*
   1、确定程序相关变量
    1.1、char[] chs随机生成的数组
    1.2、char[] input用户输入的数组
    1.3、int[] lev游戏难度等级
    1.4、int[] result存放检查的两个结果
   2、确定程序结构
    2.1、确定整段代码的主程序入口
    public static void main(String [] args){}
    2.2、 声明程序所需要的方法
        2.2.1、方法一：随机数组的产生
        public static char[]generate() {}
        2.2.2、方法二：比较生成数组和输入数据，将结果存进int[] result中
        public static int[] result(){}
 */
public class LettersGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("游戏开始!");
        int lev;//声明游戏难度等级
        while (true) {//自造死循环，确保为5、7、9中的任意一个数
            System.out.println("请输入难度等级：5、7、9");
            lev = scanner.nextInt();
            if (lev == 5 || lev == 7 || lev == 9) {
                break;
            }
        }
        char[] chs = generate(lev);
        System.out.println(Arrays.toString(chs));
        int count = 0;//声明count为答错的次数，用于计算得分
        while (true) {
            System.out.println("请输入你的猜测：");
            String string;
            string = scanner.next().toUpperCase();//转化成大写
            if (string.equals("EXIT")) {
                System.out.println("下次再来....");
                break;
            }
            char[] input = string.toCharArray();//字符串转数组
            int result[] = check(chs, input);
            if (result[1] == lev) {//完全猜对的情况，位置数== 数组长度
                int score = lev * 100 - 10 * count;
                System.out.println("猜对了！得分为：" + score + "分");
                break;
            } else {
                System.out.println("你猜对了" + result[0] + "个，正确的位置猜对了" + result[1] + "个！");//没有全猜对
                count++;
            }
        }

    }

    //generate 方法
    public static char[] generate(int lev) {
        char[] chs = new char[lev];
        char[] letter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        boolean[] flag = new boolean[letter.length];//开关语句
        for (int i = 0; i < lev; i++) {//遍历赋值
            int index;
            //do while 检测重复字符
            do {
                index = (int) (Math.random() * 26);//index=[0,25]对应索引下标
            } while (flag[index] == true);
            chs[i] = letter[index];
            flag[index] = true;
        }
        return chs;
    }

    //check 方法
    public static int[] check(char[] chs, char[] input) {
        int[] result = new int[2];//遍历比较
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (chs[i] == input[j]) {//字符正确，result[0]+1
                    result[0]++;
                    if (i == j) {//位置正确，result[1]+1
                        result[1]++;
                        break;//字符无重复，一旦检测到相同字符立刻跳出本次循环
                    }
                }
            }
        }
        return result;
    }


}
