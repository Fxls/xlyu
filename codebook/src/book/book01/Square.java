/**
 * @Author xlyu
 * @Date 2019/3/6 0006
 * @Description
 */
package book.book01;

/**
 * @program: document3.6
 * @description: for 打印正方形
 * @author: xlyu
 * @create: 2019-03-06 13:10
 **/
public class Square {

    public static void main(String[] args) {
        for (int j = 0; j < 5; j++) {//行数
            for (int i = 0; i < 10; i++) {//字符“.”数
                System.out.print(".");
            }
            System.out.println();
        }
    }
}
