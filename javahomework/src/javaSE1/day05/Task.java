/**
 * @Author xlyu
 * @Date 2019/4/3
 * @Description
 */
package javaSE1.day05;

import java.io.File;
import java.io.IOException;

/**
 * @program: javaHomework
 * @description: 作业第8题, 第9题,第10题
 * @author: xlyu
 * @create: 2019-04-03 19:39
 **/
public class Task {
    public static void main(String[] args) throws IOException {
        /*创建demo文件夹*/
        File file = new File("E:\\soft\\git\\xlyu\\javahomework\\demo");
        file.mkdir();

        /*创建demo文件夹下的HelloWord.txt文件*/
        File newFile = new File("E:\\soft\\git\\xlyu\\javahomework\\demo\\HelloWord.txt");
        newFile.createNewFile();

        /*输出文件大小*/
        System.out.println(newFile.length());//0

        /*查看src大小*/
        File srcFile = new File("E:\\soft\\git\\xlyu\\javahomework\\src");
        System.out.println(srcFile.length());//4096

        /*创建多级目录*/
        File dirsFile = new File("E:\\soft\\git\\xlyu\\javahomework\\a\\b\\c");
        dirsFile.mkdirs();

        /*删除多级目录*/
        dirsFile.delete();
        File dirsDelete = new File("E:\\soft\\git\\xlyu\\javahomework\\a\\b");
        File dirsDelete2 = new File("E:\\soft\\git\\xlyu\\javahomework\\a");
        dirsDelete.delete();
        dirsDelete2.delete();
    }
}
