/**
 * @Author xlyu
 * @Date 2019/3/8 0008
 * @Description
 */
package basic.day06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: javahomework
 * @description: 猜字母游戏v2.0(高级版本)：用户指定游戏难度（5、7、9），
 * 程序生成随机不重复字母。用户猜错，提示用户对的字母数量和对的位置数量。
 * <p1>
 * 分析猜字母游戏可以看出，此程序需要存储随机生成的字母个数、随机生成的字符串、玩家猜测的总次数、
 * 玩家录入的字符串，以及比较后的结果。因此，设计如下变量来存储此游戏中需要用到的相关数据：
 * <p2>
 * 1.声明变量
 * int 类型变量 count：用于记录玩家猜字母的总次数；
 * char数组类型变量 input：用于保存用户猜测的数据。
 * char数组类型变量 chs： 用于保存随机生成的多个字母所组成的字符串；
 * int 类型数组变量 result ：用于保存判断的结果。此数组有两个元素，
 * 第一个用于保存完全猜对的字母个数，第二个元素用于保存猜对的字母的位置个数
 * <p3>
 * 2.确定程序结构
 * 2.1、主程序public static void main(String [] args){}
 * 2.2、声明方法
 * 2.2.1方法一：生成随机数组chs
 * 2.2.2方法二:比较生成数组和输入的数据，获取result的值贮存在一个新数组中（check）
 * @author: xlyu
 * @create: 2019-03-08 18:50
 **/
public class LetterGuess2 {
    //   步骤一：设计主程序（先大概罗列，后续补充完整）
    public static void main(String[] args) {
        int count = 0;//声明count用于计分
        int lev;//声明游戏等级
        System.out.println("猜字母游戏开始！");
        Scanner scanner = new Scanner(System.in);
        /*
        这里运用while（true）语句，自造死循环，只有满足
        某种特殊条件if(){}时才可以退出循环
         */
        while (true) {
            System.out.println("请输入游戏难度：5、7、9");
            lev = scanner.nextInt();
            if (lev == 5 || lev == 7 || lev == 9) {
                break;
            }
        }
        //生成随机字符数组，调用方法generate
        char[] chs = generateArr(lev);
        //作弊代码，用于检查程序运行结果正确与否
        System.out.println(Arrays.toString(chs));
        while (true) {

            System.out.println("请输入你的猜测字符：");
            //这里toUpperCase的作用是将小写转化成大写
            String string = scanner.next().toUpperCase();

            if (string.equals("EXIT")) {
                System.out.println("你东西不多☺...");
                break;
            }
            //将输入的字符串转化成字符数组，这里用到toCharArray()
            char[] input = string.toCharArray();
            //声明result数组，调用check方法，获取返回值
            int[] result = check(chs, input);

            if (result[1] == lev) {
                int score = lev * 100 - 10 * count;
                System.out.println("你猜对了！" + "得分为" + score + "分！");
                break;
            } else {
                count++;
                System.out.println("你猜对了" + result[0] + "个字母," + "正确的位置为" + result[1] + "个！");

            }
        }
    }

    /*
    步骤二：
    
    声明方法一：
        随机一个数组，再对其进行赋值
     */
    public static char[] generateArr(int lev) {
        //给定字母表，确定赋值的元素都为A~Z
        char[] letters = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] chs = new char[lev];//声明chs为随机生成的数组
        boolean[] flag = new boolean[letters.length];//flag开关语句，默认值为flase
        /*
        这里运用了boolean类型数组，数组中储存的元素都为逻辑值false，作用为开关语句，
        阻止该程序中的字符重复问题，当输出的值为false，才可以进行下一个元素的赋值，否则，将一直
        在字母表中寻找对应的字母，如果赋值重复，将一直对应true，一直到寻找到false值为止，
        每寻找一次成功就将开关值false转变为true，然后继续执行循环体。
         */
        for (int i = 0; i < chs.length; i++) {//遍历赋值数组中元素
            int idex;//声明下标变量
            do {
                idex = (int) (Math.random() * letters.length);//下标位[0,25]
            } while (flag[idex] == true);//先执行的是do，所以flag[0]一定为true

            chs[i] = letters[idex];//遍历赋值，从chs[i]开始，i初始值为0，也就是从第一位开始赋值
            flag[idex] = true;//每输出一次就将boolean数组中的值修改为true
        }
        //由于chs长度不确定，这里需要一个返回语句，来确定chs的具体长度
        return chs;
    }

    /**
     * 步骤三：
     * <p>
     * 声明方法二：
     * 比较玩家输入的字母序列和程序所生成的字母序列，逐一比较字符及其位置，并记载比较结果
     * <p1>
     * chs
     * 程序生成的字符序列
     * <p2>
     * input
     * 玩家输入的字符序列
     * <p3>
     * resu 存储比较的结果。返回值int数组 的长度为2，其中，索引为0的位置
     * 用于存放完全猜对的字母个数，索引为1的位置用于存放猜对的位置个数
     * (字符正确，但是位置不正确)。
     */
    public static int[] check(char[] chs, char[] input) {
        //声明result，给定长度为2，resul[0]用于存储正确的字符数，resul[1]用于存储正确的位置数
        int result[] = new int[2];
        //双层for循环用于比较chs和input，用法类似于冒泡排序，用chs的每个元素与input的每个元素比较
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (chs[i] == input[j]) {
                    result[0]++;//字符数
                    if (i == j) {
                        result[1]++;//位置
                    }
                    //当猜对时不用继续往下循环，因为输出的字符规定不重复，所以这里用break跳出本次循环（break就近原则）
                    break;
                }
            }

        }
        return result;
    }
}
