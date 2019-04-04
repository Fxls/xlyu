/**
 * @Author xlyu
 * @Date 2019/4/4
 * @Description
 */
package javaSE2.day01;

import java.io.File;
import java.nio.file.FileStore;

/**
 * @program: javaHomework
 * @description: 打印盘符
 * @author: xlyu
 * @create: 2019-04-04 10:16
 **/
public class ListRoot {
    public static void main(String[] args) {
        File file = new File("E:/soft");
        File[] root = file.listRoots();
        for (File f : root) {
            System.out.print(f.getAbsolutePath() + "\t");// C:\	D:\	E:\	F:\
        }
    }

}
