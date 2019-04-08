/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/**
 * @program: javaHomework
 * @description: 将文件a.txt分割成两个文件，b.txt和c.txt
 * @author: xlyu
 * @create: 2019-04-06 13:55
 **/
public class SplitFile {
    public static void main(String[] args) throws Exception {
        byte[] bytes = "12345678900987654321".getBytes();
        FileOutputStream fos = new FileOutputStream("demo/a.txt");
        fos.write(bytes);
        fos.close();

        FileInputStream fis = new FileInputStream("demo/a.txt");
        FileOutputStream fosB = new FileOutputStream("demo/b.txt");
        FileOutputStream fosC = new FileOutputStream("demo/c.txt");
        fis.skip(10);
        int d;
        while ((d = fis.read()) != -1) {
            fosC.write((char) d);
        }
        fosC.close();
        fis.close();
        fosB.write(bytes, 0, 10);
        fos.close();
        fis.close();
    }

}
