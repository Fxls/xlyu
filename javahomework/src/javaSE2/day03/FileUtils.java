/**
 * @Author xlyu
 * @Date 2019/4/8
 * @Description
 */
package javaSE2.day03;


import java.io.*;

/**
 * @program: javaHomework
 * @description: 文件复制（try-catch）
 * @author: xlyu
 * @create: 2019-04-08 14:50
 **/
public class FileUtils {

    public static void copy(String src, String dest) {
        File fileSrc = new File(src);
        File fileDest = new File(dest);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            /**
             * 判断dest是否是文件路径，如果是文件夹路径，则在此目录下创建copy文件
             */
            if (dest == src) {
                System.out.println("请不要输入和源文件一样的路径");
                return;
            }
            /*文件夹判断方式（不是一个文件，且不存在（创建文件夹））*/
            if (!fileDest.isFile() || !fileDest.exists()) {
                System.out.println(fileDest);
                fileDest.mkdirs();
                /*在此文件夹下创建srcCopy.txt文件*/
                dest = dest + "/srcCopy.txt";
            }
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            bos = new BufferedOutputStream(fos);
            int length = -1;
            byte[] bytes = new byte[255];
            while (true) {
                try {
                    if (!((length = fis.read(bytes)) != -1)) break;
                } catch (IOException e) {
                    System.out.println("read 错误");
                }
                try {
                    bos.write(bytes, 0, length);
                } catch (IOException e) {
                    System.out.println("write 错误");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("非法路径！");
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("fis.close错误");
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    System.out.println("bos.close错误");
                }
            }
        }
    }

    public static void main(String[] args) {
        copy("demo/PW.txt", "demo/ab/cd");
    }

}
