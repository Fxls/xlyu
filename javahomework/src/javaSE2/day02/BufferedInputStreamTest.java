/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @program: javaHomework
 * @description: 缓冲输入流
 * @author: xlyu
 * @create: 2019-04-06 10:22
 **/
public class BufferedInputStreamTest {

    @Test
    public void bisTest() throws Exception {
        FileInputStream fis = new FileInputStream("demo/BOS.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        int d = -1;
        while ((d = bis.read()) != -1) {
            System.out.print((char) d);//bos:2019/4/6bos:2019/4/6/flush
        }
        bis.close();
    }
}
