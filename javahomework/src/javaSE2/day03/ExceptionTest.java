/**
 * @Author xlyu
 * @Date 2019/4/8
 * @Description
 */
package javaSE2.day03;

import javaSE2.day02.Emp;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: javaHomework
 * @description: 异常测试
 * @author: xlyu
 * @create: 2019-04-08 14:13
 **/
public class ExceptionTest {

    @Test
    public void test() {
        try {
            FileInputStream fis = new FileInputStream("8/9/10");
            int d = -1;
            while (true) {
                try {
                    if (!((d = fis.read()) != -1)) break;//break,如果执行try语句，跳出while
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println((char) d);
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("非法路径！");
        }
    }

    @Test
    public void test2() {
        Emp emp = null;
        try {
            emp.getName();
        } catch (NullPointerException e) {
            System.out.println("空指针异常！");

            /*父类异常一定要写在子类异常下面*/
        } catch (Exception e1) {
            System.out.println("父类异常");
        } finally {
            System.out.println("finally已经执行");
        }

        System.out.println("over");
        /**
         * 程序运行结果如下
         *  空指针异常！
         *  finally已经执行
         *  over
         */
    }

    /**
     * printStackTrance测试
     */
    @Test
    public void printStackTrance() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("8/9/10");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("close失败");
                }
            }
        }
        /**
         * 控制台输出结果
         *    java.io.FileNotFoundException: 8\9\10 (系统找不到指定的路径。)
         * 	at java.io.FileInputStream.open0(Native Method)
         * 	at java.io.FileInputStream.open(FileInputStream.java:195)
         * 	at java.io.FileInputStream.<init>(FileInputStream.java:138)
         * 	at java.io.FileInputStream.<init>(FileInputStream.java:93)
         * 	at javaSE2.day03.ExceptionTest.printStackTrance(ExceptionTest.java:72)
         */
    }

    @Test
    public void test3() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("8/9/10");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());//8\9\10 (系统找不到指定的路径。)
            System.out.println(e.getCause());//null
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("close失败");
                }
            }
        }
    }

    @Test
    public void test4() {
        try {
            FileInputStream fis = new FileInputStream("8/9/10");
        } catch (FileNotFoundException e) {
            /*catch块中转为非检测异常*/
            throw new RuntimeException();
        }
    }
}


