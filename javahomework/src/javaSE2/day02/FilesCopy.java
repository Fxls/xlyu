/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @program: javaHomework
 * @description: 文件复制的各种实现方式
 * @author: xlyu
 * @create: 2019-04-06 10:04
 **/
public class FilesCopy {

    /**
     * 通过fis和fos实现文件复制（一个字节一个字节的读写）
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        FileInputStream fis = new FileInputStream("E:/soft/git/xlyu/javahomework/demo/FOS.txt");
        FileOutputStream fos = new FileOutputStream("E:/soft/git/xlyu/javahomework/demo/FOS_copy1.txt");
        int d = -1;
        while ((d = fis.read()) != -1) {
            fos.write(d);
        }
        fis.close();
        fos.close();
    }

    /**
     * 文件复制（多字节读写操作）
     */
    @Test
    public void test2() throws Exception {
        FileInputStream fis = new FileInputStream("demo/FOS.txt");
        FileOutputStream fos = new FileOutputStream("demo/FOS_copy2.txt");
        int length = -1;

        /*一次读五个字节写五个字节，提高读写效率*/
        byte[] bytes = new byte[5];
        while ((length = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, length);
        }
        fis.close();
        fos.close();
    }

    /**
     * 文件复制，缓冲实现
     */
    @Test
    public void test3() throws Exception {
        FileInputStream fis = new FileInputStream("demo/BOS.txt");
        FileOutputStream fos = new FileOutputStream("demo/BOS_copy3.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int length = -1;
        byte[] bytes = new byte[10];
        while ((length = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, length);
        }
        bis.close();
        bos.close();
    }
}
