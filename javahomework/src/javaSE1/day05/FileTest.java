/**
 * @Author xlyu
 * @Date 2019/4/3
 * @Description
 */
package javaSE1.day05;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @program: javaHomework
 * @description: File测试
 * @author: xlyu
 * @create: 2019-04-03 09:48
 **/
public class FileTest {

    /**
     * File类的基础测试:File是io包下的一个类，是文件和目录路径的抽象表示，不能对文件内内容访问
     */
    @Test
    public void test() {
        /*使用不同的构造器创建实例，可以用separator表示路径分隔符*/
        File file = new File("E:/soft/git/xlyu/javahomework/resource");

        /*File有多种构造，根据具体情况选择不同的构造器*/
        File file1 = new File(file, "I.png");

        /*isFile判断对象是否为一个文件*/
        System.out.println(file.isFile());//false
        System.out.println(file1.isFile());//true

        /*length方法：文件所占用的字节量*/
        System.out.println(file.length());//4096
        System.out.println(file1.length());//3008

        /*判断File对象是否存在（文件&目录）*/
        System.out.println(file.exists());//true
        System.out.println(file1.exists());//true
    }

    @Test
    public void test2() throws IOException {
        /*createNewFile:创建一个空文件*/
        File file = new File("E:/soft/git/xlyu/javahomework/create.txt");
        file.createNewFile();

        /*mkdir:创建单级目录*/
        File file1 = new File("E:/soft/git/xlyu/javahomework/mkdir_test");
        file1.mkdir();

        /*mkdirs:创建多级目录*/
        File file2 = new File("E:/soft/git/xlyu/javahomework/mkdirs_test/mkdirs_test2/mkdirs_test3");
        file2.mkdirs();

        /*isDirectory:判断是否是一个目录*/
        System.out.println(file.isDirectory());//false
        System.out.println(file1.isDirectory());//true

        /*delete:删除文件或空目录*/
        file2.delete();
        file.delete();
    }
}
