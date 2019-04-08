/**
 * @Author xlyu
 * @Date 2019/4/8
 * @Description
 */
package javaSE2.day03;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @program: javaHomework
 * @description: 缓冲字符输入流
 * @author: xlyu
 * @create: 2019-04-08 09:29
 **/
public class BufferedReaderTest {

    @Test
    public void test() throws Exception {
        /**
         * 这里需要注意BR是Reader的子类，要对低级流进行包装
         */
        FileInputStream fis = new FileInputStream("demo/Pw.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);//将PW.txt中文件成行打印
        }
        br.close();
    }
}
