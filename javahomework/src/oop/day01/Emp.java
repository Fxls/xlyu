/**
 * @Author xlyu
 * @Date 2019/3/11 0011
 * @Description
 */
package oop.day01;

/**
 * @program: javahomework
 * @description:创建Emp类采集员工信息；其中包含姓名、性别、薪水、年龄等变量，此类中包含打印信息的方法
 * @author: xlyu
 * @create: 2019-03-11 15:49
 **/
public class Emp {
    String name;
    int age;
    char gender;
    double salary;

    public static void main(String[] args) {
        Emp emp = new Emp();//创建Empduixiang
        //调用Emp中的变量
        emp.name = "123";
        emp.age = 12;
        emp.gender = '男';
        emp.salary = 120.0;
        emp.printInfo();
    }

    public void printInfo() {
        System.out.println("-----------------------------");
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("性别：" + gender);
        System.out.println("薪水：" + salary);
    }
}

