/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import org.junit.Test;

import java.io.FileInputStream;


/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-04-06 09:57
 **/
public class FileInputStreamTest {

    @Test
    public void test() throws Exception {
        FileInputStream fis = new FileInputStream("E:/soft/git/xlyu/javahomework/demo/FOS.txt");
        int d = -1;
        while ((d = fis.read()) != -1) {
            System.out.print((char) d);//2019/4/6 STU
        }
        fis.close();
    }
}
