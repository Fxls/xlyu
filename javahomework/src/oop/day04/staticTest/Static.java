/**
 * @Author xlyu
 * @Date 2019/3/15 0015
 * @Description
 */
package oop.day04.staticTest;

/**
 * @program: javahomework
 * @description: static测试
 * @author: xlyu
 * @create: 2019-03-15 14:20
 **/
public class Static {
    static String gender = "男";
    int age = 0;

    public Static() {
        gender = "!";
    }

    public void Test0(String gender) {
        age = 1;
        Static.gender = gender;
        gender = "!";
        System.out.println(gender);
        Test1("*");
    }

    public static void Test1(String gender) {
        Static sta = new Static();
        sta.Test0("*");
        Static.gender = gender;
        gender = "-";
        sta.age = 15;
        System.out.println(gender);
    }

    public static void main(String[] args) {
        Static sta = new Static();
        System.out.println(sta.age);
        System.out.println(gender);
        sta.Test0("?");
        Static.Test1("!");
    }

    class Static2 extends Static {
        public Static2() {
            super();
            Static sta = new Static2();
            Static.Test1("1");
            sta.Test0("2");
        }
    }


}
