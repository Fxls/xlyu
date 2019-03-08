package book.book01; /**
 * @Author xlyu
 * @Date 2019/3/6 0006
 * @Description
 */

/**
 * @program: document3.6
 * @description: for平行四边形
 * @author: xlyu
 * @create: 2019-03-06 13:44
 **/
public class Parallelogram {


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) { // 行数
            for (int j = 10; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < 10; j++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }
}
