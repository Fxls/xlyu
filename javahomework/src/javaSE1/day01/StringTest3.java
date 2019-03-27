/**
 * @Author xlyu
 * @Date 2019/3/25 0025
 * @Description
 */
package javaSE1.day01;

/**
 * @program: javahomework
 * @description: 字符串测试3
 * <p>
 * 特例2
 * @author: xlyu
 * @create: 2019-03-25 15:17
 **/
    public class StringTest3 {
        private static final String A;
        private static final String B;

        static {
            A = "ab";
            B = "cd";
        }

        public static void main(String[] args) {
            String s = A + B;
            String t = "abcd";
            if (s == t) {
                System.out.println("同一个对象");
            } else {
                System.out.println("不.是同一个对象");
            }


            //输出结果：不是同一个对象。AB虽然都是常量但是都没有被马上赋值。在运算s之前，
            //        他们何时被赋值都是不确定的。因此AB在被赋值之前，性质类似于一个变量。那么s就不能在编译期被确定，
            //        而只能在运行时被创建了
        }

}
