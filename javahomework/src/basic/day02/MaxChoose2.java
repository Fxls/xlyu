/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package basic.day02;

/**
 * @program: day02.code
 * @description: 输入三个int数，输出最大的int数
 * @author: xlyu
 * @create: 2019-03-05 17:42
 **/
public class MaxChoose2 {

    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入三个数：");
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//        scanner.close();
//        if (a - b >= 0 && a - c >= 0) {
//            System.out.println("最大的数是：" + a + "!");
//        }
//        if (b - a > 0 && b - c >= 0) {
//            System.out.println("最大的数是：" + b + "!");
//        }
//        if (c - a > 0 && c - b > 0) {
//            System.out.println("最大的数是：" + c + "!");
//        }
//    }
    public static void main(String[] args) {
        int a, b, c;
        a = (int) (Math.random() * 100);
        b = (int) (Math.random() * 100);
        c = (int) (Math.random() * 100);
        System.out.println(a + "  " + b + "  " + c);
        int[]arr ;
        arr = new int[]{a,b,c};

//
//        if (a > b) {
//            int t = a;
//            b = a;
//            a = t;
//            if (b > c) {
//                int t2 = b;
//                c = b;
//                b = t2;
//                System.out.println(b);
//            } else {
//                System.out.println(c);
//            }
//            System.out.println(a);
//        }
//

    }
}
