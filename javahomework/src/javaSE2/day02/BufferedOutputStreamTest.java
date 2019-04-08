/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * @program: javaHomework
 * @description: 缓冲输出流
 * @author: xlyu
 * @create: 2019-04-06 10:23
 **/
public class BufferedOutputStreamTest {

    @Test
    public void bosTest() throws Exception {
        FileOutputStream fos = new FileOutputStream("demo/BOS.txt");

        /*使用BOS包装低级的FOS*/
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("bos:2019/4/6".getBytes());
        /**
         * 使用高级流包装低级流时，可以只关闭高级流的开关，当启用缓冲流的close方法时，缓冲区的
         * 内容将被一次性取出
         */
        bos.close();
    }

    @Test
    public void flushTest() throws Exception {
        FileOutputStream fos = new FileOutputStream("demo/BOS.txt", true);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("bos:2019/4/6/flush".getBytes());
        /*将缓冲区的内容取出*/
        bos.flush();
        bos.close();
    }
}
