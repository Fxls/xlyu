/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @program: javaHomework
 * @description: 字符输出流
 * @author: xlyu
 * @create: 2019-04-06 12:07
 **/
public class OutputStreamWriterTest {

    @Test
    public void test() throws Exception {
        FileOutputStream fos = new FileOutputStream("demo/osw.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        osw.write("osw2019/4/6");
        osw.close();
    }
}
