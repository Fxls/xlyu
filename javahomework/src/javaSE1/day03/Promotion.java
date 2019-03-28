/**
 * @Author xlyu
 * @Date 2019/3/28 0028
 * @Description
 */
package javaSE1.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @program: javaHomework
 * @description: 促销日期
 * @author: xlyu
 * @create: 2019-03-28 19:54
 **/
public class Promotion {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入生产日期：yyyy-MM-dd");
        String dateOfManufacture = sc.next();
        System.out.println("输入保质期：（天）");
        int qualityGuaranteePeriod = sc.nextInt();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateOfManufacture);//固定

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, (qualityGuaranteePeriod-14));

        Date date1 = new Date(String.valueOf(c.getTime()));
        System.out.println(sdf.format(date1));


    }
}
