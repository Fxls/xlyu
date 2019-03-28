/**
 * @Author xlyu
 * @Date 2019/3/28 0028
 * @Description
 */
package javaSE1.day03;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: javaHomework
 * @description: SDF测试
 * @author: xlyu
 * @create: 2019-03-28 15:50
 **/
public class SimpleDateFormatTest {

    @Test
    /**
     * @Param
     * @description TODO SDF是一个以与语言环境有关的方式来格式化和解析日期的具体类。它允许
     *                   进行格式化（日期->文本）、解析（文本->日期）和规范化
     * @date 2019/3/28 0028 15:54
     * @return void
     */
    public void test() throws ParseException {
        /*y-年、M-月、d-日、E-星期几、a-AM&PM、H-24时制、h-12小时制、m-分、s、秒*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E a hh:mm:ss");
        Date date = new Date();
        String dateStr = sdf.format(date);
        System.out.println(dateStr);//2019-03-28 星期四 下午 03:59:11

        String str = "2019-03-28";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = sdf2.parse(str);//需要throwException
        System.out.println(date2);//Thu Mar 28 00:00:00 CST 2019：因为str和sdf2没有对于时分秒的设置

        /*重新细化后的输出，这里要注意格式的对仗否则会出现java.text.ParseException: Unparseable date*/
        String str2 = "2019-03-28  16:11:25";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date3 = sdf3.parse(str2);
        System.out.println(date3);//Thu Mar 28 16:11:25 CST 2019
    }
}
