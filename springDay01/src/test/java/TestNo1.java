/**
 * @Author xlyu
 * @Date 2019/6/24
 * @Description
 */

import com.itek.spring.day01.module.HungryMan;
import com.itek.spring.day01.module.LazyMan;
import com.itek.spring.day01.module.User;

/**
 * @program: springDay01
 * @description:
 * @author: xlyu
 * @create: 2019-06-24 15:30
 **/
public class TestNo1 {
    public static void main(String[] args) {
        /**
         * 懒汉模式和饿汉模式都是单例模式，区别在于创建bean的时机不同。
         */
        LazyMan lazyMan = LazyMan.getInstance();
        LazyMan lazyMan1 = LazyMan.getInstance();
        System.out.println(lazyMan == lazyMan1);
        User user = new User();
        User user1 = new User();
        System.out.println(user == user1);

//        HungryMan hungryMan = HungryMan.getInstance();
//        HungryMan hungryMan1 = HungryMan.getInstance();
//        System.out.println(hungryMan == hungryMan1);
    }
}
