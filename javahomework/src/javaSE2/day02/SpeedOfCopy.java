/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import org.junit.Test;

import java.io.*;

/**
 * @program: javaHomework
 * @description: 比较不同文件复制方式的速度, 我传了一个mp3类型的文件，8.94m，用于比较各种文件
 * 复制的快慢
 * <p>
 * 通过以下测试
 * <p>
 * test1测试时间为51458ms
 * <p>
 * test2测试时间为366ms
 * <p>
 * test3测试时间为587ms
 * <p>
 * test4测试时间为54ms
 * <p>
 * 不难看出，在文件复制时，单个字节的读写比多个字节读写要慢很多，而对普通IO流又比高级的缓冲流
 * 要满很多
 * @author: xlyu
 * @create: 2019-04-06 10:55
 **/
public class SpeedOfCopy {

    /**
     * 第一种，利用fis和fos，一个字节一个字节的读写进行复制
     */
    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("demo/周杰伦 - 爱 在西 元前.mp3");
        FileOutputStream fos = new FileOutputStream("demo/周杰伦 - 爱 在西 元前_copy.mp3");
        int d = -1;
        while ((d = fis.read()) != -1) {
            fos.write((char) d);
        }
        fis.close();
        fos.close();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);//51458ms->51.458s
    }

    /**
     * 第二种，利用fis和fos，多个字节的读写进行复制
     */
    @Test
    public void test2() throws Exception {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("demo/周杰伦 - 爱 在西 元前.mp3");
        FileOutputStream fos = new FileOutputStream("demo/周杰伦 - 爱 在西 元前_copy2.mp3");
        int length = -1;
        byte[] bytes = new byte[255];
        while ((length = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, length);
        }
        fis.close();
        fos.close();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);//366ms->0.366s
    }

    /**
     * 第三种，利用缓冲流，一个字节一个字节的读写进行复制
     */
    @Test
    public void test3() throws Exception {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("demo/周杰伦 - 爱 在西 元前.mp3");
        FileOutputStream fos = new FileOutputStream("demo/周杰伦 - 爱 在西 元前_copy3.mp3");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int d = -1;
        while ((d = bis.read()) != -1) {
            bos.write((char) d);
        }
        bis.close();
        bos.close();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);//587ms->0.587s
    }

    /**
     * 第四种，利用缓冲流，多个字节的读写进行复制
     */
    @Test
    public void test4() throws Exception {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("demo/周杰伦 - 爱 在西 元前.mp3");
        FileOutputStream fos = new FileOutputStream("demo/周杰伦 - 爱 在西 元前_copy4.mp3");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int length = -1;
        byte[] bytes = new byte[255];
        while ((length = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, length);
        }
        bis.close();
        bos.close();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);//54ms->0.054s
    }
}
