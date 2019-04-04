/**
 * @Author xlyu
 * @Date 2019/4/3
 * @Description
 */
package javaSE2.day01;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @program: javaHomework
 * @description: 第四题
 * @author: xlyu
 * @create: 2019-04-03 20:21
 **/
public class Task04 {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\soft\\git\\xlyu\\javahomework\\demo\\Task04.txt");
        File file1 = new File("E:\\soft\\git\\xlyu\\javahomework\\demo\\Task04.2.txt");
        file.createNewFile();
        file1.createNewFile();
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        RandomAccessFile raf2 = new RandomAccessFile(file1, "rw");
        int d = -1;

        /*如果d！=-1，说明没到文件末尾，那就write当前指针的内容，直到文件末尾截止，实现文件复制*/
        while ((d = raf.read()) != -1) {
            raf2.write(d);
        }

        raf.close();
        raf2.close();
    }
}
