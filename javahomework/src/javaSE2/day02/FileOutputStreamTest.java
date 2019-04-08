/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @program: javaHomework
 * @description: 文件输出流
 * @author: xlyu
 * @create: 2019-04-06 09:46
 **/
public class FileOutputStreamTest {
    @Test
    public void test() throws Exception {
        /*FOS文件输出流，实例化一个FOS对象*/
        FileOutputStream fos = new FileOutputStream("E:/soft/git/xlyu/javahomework/demo/FOS.txt");
        fos.write("2019/4/6".getBytes());
        fos.close();
    }

    @Test
    public void append() throws Exception {
        /*使用FOS追加模式的构造，实现追加功能*/
        FileOutputStream fos = new FileOutputStream("E:/soft/git/xlyu/javahomework/demo/FOS.txt", true);
        fos.write(" STU".getBytes());
        fos.close();
    }

}
