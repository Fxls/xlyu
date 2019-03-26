/**
 * @Author xlyu
 * @Date 2019/3/25 0025
 * @Description
 */
package javaSE1.day01;

import org.junit.Test;

/**
 * @program: javaHomework
 * @description: string的一些方法应用
 * @author: xlyu
 * @create: 2019-03-25 15:26
 **/
public class String_Methods {


    @Test
    /**
     * @Param
     * @description TODO charAt(int index)(用于返回字符串中对应index的字符，返回类型为char)
     * @date 2019/3/25 0025 15:38
     * @return void
     */
    public void charAt() {
        String str = "jayChou";
        char c = str.charAt(0);
        System.out.println(c);
    }

    @Test
    /**
     * @Param
     * @description TODO equals(String other)(用于比较字符串类容，返回类型为boolean类型)
     * @date 2019/3/25 0025 15:44
     * @return void
     */
    public void equals() {
        String str = "jayChou";
        String str2 = "JayChou";
        String str3 = "jayChou";
        boolean b1 = str.equals(str2);
        boolean b2 = str.equals(str3);
        System.out.println(b1);
        System.out.println(b2);
    }

    @Test
    /**
     * @Param
     * @description TODO indexOf(String string)(用于检索一个字符串在另一个字符串出现的位置，返回类型为int，如果没有对应值则返回1)
     * @date 2019/3/25 0025 15:51
     * @return void
     */
    public void indexOf() {
        String str = "jayChou";
        String str2 = "Chou";
        int i = str.indexOf(str2);
        System.out.println(i);
    }

    @Test
    /**
     * @Param
     * @description TODO lastIndexOf(String string)(检测字符串最后一次出现的位置，返回类型为int)
     * @date 2019/3/25 0025 15:59
     * @return void
     */
    public void lastIndexOf() {
        String str = "jay Chou is jay Chou ";
        int i = str.lastIndexOf("Chou");
        System.out.println(i);
    }

    @Test
    /**
     * @Param
     * @description TODO startWith&endWith(String prefix)(检测字符串的前缀和后缀，返回类型为boolean)
     * @date 2019/3/25 0025 16:08
     * @return void
     */
    public void startWith_endWith() {
        String str = "jay-Chou";
        boolean b1 = str.startsWith("jay");
        boolean b2 = str.endsWith("Chou");
        System.out.println(b1);
        System.out.println(b2);
    }

    @Test
    /**
     * @Param
     * @description TODO substring(int beginIndex,int engIndex)(返回对应范围的字符串，注意包前不包后的原则)
     * @date 2019/3/25 0025 16:12
     * @return void
     */
    public void substring() {
        String str = "jay-Chou";
        String str2 = str.substring(4);
        String str3 = str2.substring(0, 2);
        System.out.println(str2);
        System.out.println(str3);
    }

    @Test
    /**
     * @Param
     * @description TODO toLowerCase&toUpperCase(字符串大小写转化，返回类型为String)
     * @date 2019/3/25 0025 16:17
     * @return void
     */
    public void toLowerCase_UpperCase() {
        String str = "jay-Chou";
        String str2 = str.toLowerCase();
        String str3 = str.toUpperCase();
        System.out.println(str2);
        System.out.println(str3);
    }

    @Test
    /**
     * @Param
     * @description TODO valueOf(各种类型)(将其他类型转化为字符串类型，返回类型为String)
     * @date 2019/3/25 0025 16:22
     * @return void
     */
    public void valueOf() {
        int a = 520;
        String str = String.valueOf(a);
        System.out.println(str);
    }

    @Test
    /**
     * @Param
     * @description TODO trim()(截取字符串端的空格)
     * @date 2019/3/25 0025 16:25
     * @return void
     */
    public void trim() {
        String str = "   jay    -      chou    ";
        System.out.println(str.trim());
    }

    @Test
    /**
     * @Param
     * @description TODO replace(char old,char new)(替换字符串中的字符)
     * @date 2019/3/25 0025 18:17
     * @return void
     */
    public void replace() {
        String str = "jay-Chou";
        str.replace('j', 'J');
        System.out.println(str.replace('j', 'J'));
    }
}
