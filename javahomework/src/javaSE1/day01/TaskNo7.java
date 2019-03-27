/**
 * @Author xlyu
 * @Date 2019/3/25 0025
 * @Description
 */
package javaSE1.day01;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;


/**
 * @program: javahomework
 * @description: day01第七题
 * @author: xlyu
 * @create: 2019-03-25 19:45
 **/
public class TaskNo7 {
    @Test
    /**
     * @Param
     * @description TODO leftPad(String str,int size,String padStr&char padChar)(左填充，返回类型为String)
     * @date 2019/3/26 0026 14:35
     * @return void
     */
    public void leftPad() {
        /**StringUtils中共有三种leftPad方法，三种方法的前两个参数都是一样，size是操作后字符串的length，str为要操作的字符串
         * 其中一种方法是没有最后一个添加参数的，所以就默认添加空格，如果，size小于等于原字符串的length则返回原字符串，如果大于则进行
         * 左填充，一直填到length为size为止，其中注意填充参数为PadStr的方法，如果填不满则循环填充直到填满为止。
         * */
        System.out.println(StringUtils.leftPad("567", 7, "1234"));
        System.out.println(StringUtils.leftPad("...", 10, '.'));
        System.out.println(StringUtils.leftPad("...", 5));
    }

    @Test
    /**
     * @Param
     * @description TODO rightPad(String str,int size,String padStr&char padChar)(右填充，返回类型为String)
     * @date 2019/3/26 0026 14:53
     * @return void
     */
    public void rightPad() {
        /**具体功能和leftPad类似*/
        System.out.println(StringUtils.rightPad("--", 1));
        System.out.println(StringUtils.rightPad("**", 8, '/'));
        System.out.println(StringUtils.rightPad("*-*", 12, "^-^"));
    }

    @Test
    /**
     * @Param
     * @description TODO repeat(String str,int repeat)(重复字符串)
     * @date 2019/3/26 0026 15:02
     * @return void
     */
    public void repeat() {
        System.out.println(StringUtils.repeat("dududu ", 2));//小于零的话返回空字符
    }

    @Test
    /**
     * @Param
     * @description TODO abbreviate(String str, int offset, int maxWidth)(缩减字符串)
     * @date 2019/3/26 0026 15:24
     * @return void
     */
    public void abbreviate() {
        /**此方法中，maxWidth的值应该大于等于四，因为三个点就占用三个字符，至少保留首字符，注意想缩减的话，需要特别注意str的length
         * 因为str的length小于等于4是没意义的。
         * */
        System.out.println(StringUtils.abbreviate("Test1322222222223323232", 4));

        /**如果想输出两端都带’.’的字符串，则offset必须大于4，且str.length-offset必须大于4，输出的字符为对应索引下标的位置到
         * （maxWidth-offset）-1+offset对应索引下标的位置，即maxWidth-1的位置，且输出的字符数目为max-off，如果想输出前面带有
         * '.'的串则需要满足max-off<6。总的来说，具体方法的实现需要观察字符串的特点。
         * */
        System.out.println(StringUtils.abbreviate("12345678900000", 6, 11));
    }

    @Test
    /**
     * @Param
     * @description TODO join()(字符串的拼接)
     * @date 2019/3/26 0026 16:23
     * @return void
     */
    public void join() {
        String[] s = {"Jay", "Chou", "have", "a", "daughter"};
        System.out.println(StringUtils.join(s, "-"));
    }


}

