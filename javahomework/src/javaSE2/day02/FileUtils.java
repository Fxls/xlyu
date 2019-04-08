/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import java.io.*;

/**
 * @program: javaHomework
 * @description: src->dest
 * @author: xlyu
 * @create: 2019-04-06 15:22
 **/
public class FileUtils {
    private File src;
    private File dest;

    public FileUtils(File src, File dest) {
        this.src = src;
        this.dest = dest;
    }

    public static void copyFile(File src, File dest) throws Exception {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int length = -1;
        byte[] bytes = new byte[255];
        while ((length = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, length);
        }
        bis.close();
        bos.close();
    }
}
