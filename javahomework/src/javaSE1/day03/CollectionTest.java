/**
 * @Author xlyu
 * @Date 2019/3/28 0028
 * @Description
 */
package javaSE1.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @program: javaHomework
 * @description: Collection测试
 * @author: xlyu
 * @create: 2019-03-28 19:33
 **/
public class CollectionTest {
    public int age = 18;
    public String gender = "男";
    CollectionTest[] ct = new CollectionTest[1];

    @Override
    public String toString() {
        return "CollectionTest{" +
                "age=" + age +
                ", gender='" + gender + '\'' +
                ", ct=" + Arrays.toString(ct) +
                '}';
    }

    public CollectionTest(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    public static void main(String[] args) {
        Collection<CollectionTest> ct = new ArrayList<CollectionTest>();
        ((ArrayList<CollectionTest>) ct).add(new CollectionTest(14, "男"));
        CollectionTest testCt = new CollectionTest(18, "女");
        ((ArrayList<CollectionTest>) ct).add(testCt);
        System.out.println(ct);
        System.out.println(testCt);
    }
}
