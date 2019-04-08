/**
 * @Author xlyu
 * @Date 2019/4/8
 * @Description
 */
package javaSE2.day03;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @program: javaHomework
 * @description:
 * @author: xlyu
 * @create: 2019-04-08 09:24
 **/
public class PrintWriterTest {

    /**
     * PW的第一种构造
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        FileOutputStream fos = new FileOutputStream("demo/PW.txt");
        PrintWriter pw = new PrintWriter(fos);
        pw.println("123");
        pw.println("456");
        pw.println("789");
        pw.println("000");
        pw.close();
    }

    /**
     * PW的第二种构造
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        FileOutputStream fos = new FileOutputStream("demo/PW.txt", true);
        PrintWriter pw = new PrintWriter(fos, true);
        pw.println(5);
        pw.println(6);
        pw.println(7);
        pw.println(9);
        pw.close();
    }
}
