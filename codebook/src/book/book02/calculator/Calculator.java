/**
 * @Author xlyu
 * @Date 2019/3/16 0016
 * @Description
 */
package book.book02.calculator;

import javax.swing.*;
import java.util.Scanner;

/**
 * @program: codebook
 * @description: 计算器
 * @author: xlyu
 * @create: 2019-03-16 10:12
 **/
public class Calculator {
    double x;//输入数1
    double y;//输入数2

    /**
     * @return
     * @Param
     * @description TODO 加法运算
     * @date 2019/3/16 0016 10:26
     */
    public void sum() {
        double sum = x + y;
        System.out.println("和是：" + sum);
    }

    /**
     * @return
     * @Param
     * @description TODO 减法运算
     * @date 2019/3/16 0016 10:31
     */
    public void subtraction() {
        double subtraction = x - y;
        System.out.println("差是：" + subtraction);
    }

    /**
     * @return
     * @Param
     * @description TODO 乘法运算
     * @date 2019/3/16 0016 10:33
     */
    public void multiplication() {
        double multiplication = (0.0 + x) * (0.0 + y);
        System.out.println("积是：" + multiplication);
    }

    /**
     * @return
     * @Param
     * @description TODO 除法运算
     * @date 2019/3/16 0016 10:36
     */
    public void division() {
        double division = (0.0 + x) / (0.0 + y);
        System.out.println("商是：" + division);
    }

    /**
     * @return
     * @Param
     * @description TODO 操作流程
     * @date 2019/3/16 0016 10:37
     */
    public void operation() {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("选择你要计算的类型：1-加法、2-减法、3-乘法、4-除法、0-退出");
            double input = scanner.nextDouble();
            if (input == 0) {
                System.out.println("over");
                break;
            } else if (input > 4) {
                System.out.println("指令错误！");
            } else {
                System.out.println("请输入第一个数");
                double x = scanner.nextDouble();
                this.x = x;
                System.out.println("请输入第二个数");
                double y = scanner.nextDouble();
                this.y = y;
                if (input == 1) {
                    sum();
                }
                if (input == 2) {
                    subtraction();
                }
                if (input == 3) {
                    multiplication();
                }
                if (input == 4) {
                    division();
                }
            }
        } while (true);
    }

}
