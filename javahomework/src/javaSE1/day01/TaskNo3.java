/**
 * @Author xlyu
 * @Date 2019/3/25 0025
 * @Description
 */
package javaSE1.day01;

/**
 * @program: javahomework
 * @description: day01作业第3题，截取someapp/manage/emplist.action中最后一个/后的内容
 * @author: xlyu
 * @create: 2019-03-25 18:35
 **/
public class TaskNo3 {
    public static void main(String[] args) {
        String str = "someapp/manager/emplist.action";

        /**method 1 -- substring*/
        int location = str.lastIndexOf("/");
        System.out.println(str.substring(location + 1));
        System.out.println(str.substring(location + 1, str.length()));//包前不包后，所以写30，到29

        /**method 2 -- StringBuilder delete*/
        StringBuilder str2 = new StringBuilder(str);
        System.out.println(str2.delete(0, location + 1));

        /**method 3 -- StringBuilder replace*/
        StringBuilder str3 = new StringBuilder(str);//这里需要新建一个str，因为上面那个对象已经被更改了
        System.out.println(str3.replace(0, location + 1, ""));
    }
}
