/**
 * @Author xlyu
 * @Date 2019/3/25 0025
 * @Description
 */
package javaSE1.day01;

import org.junit.Test;

/**
 * @program: javahomework
 * @description: StringBuilde和他的一些方法的使用
 * <p>
 * String：不可变字符序列，效率最低
 * <p>
 * StringBuilder：可变字符序列，效率高，线程不安全
 * <p>
 * StringBuffer：可变字符序列，效率较StringBuilder低，线程安全
 * @author: xlyu
 * @create: 2019-03-25 16:28
 **/
public class StringBuilder_Methods {


    @Test
    /**
     * @Param
     * @description TODO append(各种类型参数)(添加字符串的内容，返回类型是StringBuilder)
     * @date 2019/3/25 0025 16:37
     * @return void
     */
    public void append() {
        StringBuilder sb = new StringBuilder("jay - chou");
        System.out.println(sb.append("NO"));
        System.out.println(sb.append('.'));
        System.out.println(sb.append(1));

        /**append方法可以级联调用*/
        StringBuilder sb2 = new StringBuilder("jay");
        System.out.println(sb2.append('-').append(" Chou").append("NO").append('.').append(1));
    }

    @Test
    /**
     * @Param
     * @description TODO insert(各种类型参数)(在字符串中插入内容，返回类型是StringBuilder)
     * @date 2019/3/25 0025 16:44
     * @return void
     */
    public void insert() {
        StringBuilder sb = new StringBuilder("jay - chou");//从offset 后插入
        System.out.println(sb.insert(10, " have a daughter!"));//这里也可以级联调用，用法类似于append
    }

    @Test
    /**
     * @Param
     * @description TODO delete(int startIndex, int endIndex)(删除指定长度的字符串，包前不包后，返回类型是StringBuilder)
     * @date 2019/3/25 0025 16:50
     * @return void
     */
    public void delete() {
        StringBuilder sb = new StringBuilder("jay - Chou");
        System.out.println(sb.delete(3, 6));//这里也可以级联调用，用法类似于append
    }

    @Test
    /**
     * @Param
     * @description TODO replace(int start, int end, String string)(替换指定范围的字符串。返回类型为StringBuilder)
     * @date 2019/3/25 0025 16:56
     * @return void
     */
    public void replace() {
        StringBuilder sb = new StringBuilder("jay - CHOU");
        System.out.println(sb.replace(0, 3, "JAY"));//这里也可以级联调用，用法类似于append
    }

    @Test
    /**
     * @Param
     * @description TODO reverse()(翻转字符串，返回类型为StringBuilder)
     * @date 2019/3/25 0025 17:02
     * @return void
     */
    public void reverse() {
        StringBuilder sb = new StringBuilder("jay - Chou");
        System.out.println(sb.reverse().reverse().reverse());//这里也可以级联调用，用法类似于append
    }

}
