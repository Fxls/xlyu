/**
 * @Author xlyu
 * @Date 2019/4/3
 * @Description
 */
package javaSE2.day01;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/**
 * @program: javaHomework
 * @description: File测试
 * @author: xlyu
 * @create: 2019-04-03 15:50
 **/
public class FileTest {

    /**
     * listFiles：返回抽象路径名数组
     */
    @Test
    public void listFilesTest() {
        File dir = new File(".");
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.print(file);//.\.idea.\FileTest.\javaHomework.iml.\mkdirs_test.\mkdir_test.\out.\resource.\src
        }
    }

    /**
     * FileFilter:抽象路径名的过滤器
     */
    @Test
    public void testFileFilter() {
        File dir = new File(".");//.表示当前目录
        File[] list = dir.listFiles(pathname -> pathname.getName().endsWith("a"));
        for (File file : list) {
            System.out.print(file);//.\.idea
        }
    }
}
