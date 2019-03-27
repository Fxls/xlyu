/**
 * @Author xlyu
 * @Date 2019/3/27 0027
 * @Description
 */
package javaSE1.day02;

import java.util.Objects;

/**
 * @program: javaHomework
 * @description: 重写Object中的equals和toString
 * @author: xlyu
 * @create: 2019-03-27 14:40
 **/
public class OverrideTask_2 {
    private int x = 1;
    private int y = 2;

    public OverrideTask_2(int x, int y) {
        this.x = y;
        this.y = x;
    }

    @Override
    public String toString() {
        return "OverrideTask_2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OverrideTask_2 that = (OverrideTask_2) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        OverrideTask_2 o = new OverrideTask_2(5, 6);
        String str = o.toString();
        System.out.println(str);
        OverrideTask_2 o2 = new OverrideTask_2(6, 6);
        System.out.println(o2.equals(o));
    }
}
