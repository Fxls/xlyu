/**
 * @Author xlyu
 * @Date 2019/4/2
 * @Description
 */
package javaSE1.day04;

/**
 * @program: javaHomework
 * @description: Emp
 * @author: xlyu
 * @create: 2019-04-02 09:43
 **/
public class Emp {
    private String name;
    private int age;
    private char gender;
    private double salary;

    public Emp(String name, int age, char gender, double salary) {
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", salary=" + salary +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
