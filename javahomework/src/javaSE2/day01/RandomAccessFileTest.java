/**
 * @Author xlyu
 * @Date 2019/4/3
 * @Description
 */
package javaSE2.day01;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @program: javaHomework
 * @description: RAF测试
 * @author: xlyu
 * @create: 2019-04-03 16:22
 **/
public class RandomAccessFileTest {

    /**
     * RandomAccessFile类的测试
     *
     * @throws Exception
     */
    @Test
    public void testWrite() throws Exception {
        File file = new File("E:\\soft\\git\\xlyu\\javahomework\\FileTest\\RandomAccessFileTest.txt");
        file.createNewFile();
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        /*写入int的低八位,注意字符集的匹配*/
        raf.write(60);//<
        raf.write(61);//=

        /*write的重载方法，可以直接写入想要的内容，其原理是将字符串转换成byte数组*/
        raf.write("@chinese!".getBytes(), 1, 8);//chinese!

        /*close()方法用来释放与其关联的所有系统资源，每次读写操作完毕后都应该及时close*/
        raf.close();
    }

    @Test
    public void testRead() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("E:\\soft\\git\\xlyu\\javahomework\\FileTest\\RandomAccessFileTest.txt", "r");

        /**
         *read：返回值为-1则表示已经读到文件末尾了
         * read重载方法返回值为实际读到的字节量，和read无参的方法有区别
         */
        System.out.println(raf.read());//60
        System.out.println(raf.read());//61
        System.out.println(raf.read());//99
        System.out.println(raf.read("<=".getBytes()));//2
        System.out.println(raf.read("chinese".getBytes()));//5

        /*getFilePointer:用于获取当前raf的指针位置，返回一个long型*/
        System.out.println(raf.getFilePointer());//10
        System.out.println(raf.read());//-1

        /*seek:移动指针位置*/
        raf.seek(0);
        System.out.println(raf.read());//60
        raf.close();
    }

    /*skipBytes:跳过数量较少的字节*/
    @Test
    public void skipBytes() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("E:\\soft\\git\\xlyu\\javahomework\\FileTest\\RandomAccessFileTest.txt", "r");
        System.out.println("指针位置" + raf.getFilePointer());//0
        raf.skipBytes(2);
        System.out.println("指针位置"+raf.getFilePointer());//2
    }

}
