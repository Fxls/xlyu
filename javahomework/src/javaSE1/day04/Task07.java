/**
 * @Author xlyu
 * @Date 2019/4/2
 * @Description
 */
package javaSE1.day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: javaHomework
 * @description: 作业第七题
 * @author: xlyu
 * @create: 2019-04-02 09:42
 **/
public class Task07 {
    public static void main(String[] args) {
        List<Emp> emps = new ArrayList<>();
        emps.add(new Emp("Terry", 25, 'm', 6000));
        emps.add(new Emp("Allen", 21, 'f', 4000));
        emps.add(new Emp("Smith", 23, 'm', 3000));
        System.out.println(emps);//[Emp{name='Terry', age=25, gender=m, salary=6000.0}, Emp{name='Allen', age=21, gender=f, salary=4000.0}, Emp{name='Smith', age=23, gender=m, salary=3000.0}]

        /**
         * Comparator接口：
         * o1 > o2 return值大于0
         * o1 < o2 return值小于0
         * o1 == o2 return 0；
         */
        Collections.sort(emps, new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return (int) (o1.salary - o2.salary);
            }
        });
        System.out.println(emps);//[Emp{name='Smith', age=23, gender=m, salary=3000.0}, Emp{name='Allen', age=21, gender=f, salary=4000.0}, Emp{name='Terry', age=25, gender=m, salary=6000.0}]
    }
}
