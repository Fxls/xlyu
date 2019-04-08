/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @program: javaHomework
 * @description: 字符输入流
 * @author: xlyu
 * @create: 2019-04-06 12:07
 **/
public class InputStreamReaderTest {

    @Test
    public void test() throws Exception {
        FileInputStream fis = new FileInputStream("demo/osw.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        int d = -1;
        while ((d = isr.read()) != -1) {
            System.out.print((char) d);
        }
        isr.close();
    }
}
