/**
 * @Author xlyu
 * @Date 2019/4/1
 * @Description
 */
package javaSE1.day03.DIYArrayList;


/**
 * @program: javaHomework
 * @description: 自定义一个ArrayList，体会底层原理（add、set、get）
 * @author: xlyu
 * @create: 2019-04-01 09:16
 **/
public class DIYArrayList<E> {
    /*目标数组*/
    private Object[] objArr;
    /*元素数量*/
    private int size;
    /*初始数组容量*/
    private static final int FIRST = 10;

    /**
     * @return
     * @Param
     * @description TODO 无参构造
     * @date 2019/4/1 9:29
     */
    public DIYArrayList() {
        objArr = new Object[FIRST];
    }

    /**
     * @return
     * @Param
     * @description TODO 重载构造
     * @date 2019/4/1 9:29
     */
    public DIYArrayList(int next) {
        if (next <= FIRST) {
            throw new RuntimeException("" + next);
        }
        objArr = new Object[next];
    }

    /**
     * @return
     * @Param
     * @description TODO 自定义add方法,实现数组扩容，扩容设置为原数组的1.5倍
     * @date 2019/4/1 9:28
     */
    public void add(E e) {
        if (size == objArr.length) {
            Object[] newArr = new Object[objArr.length + (objArr.length >> 1)];
            System.arraycopy(objArr, 0, newArr, 0, size);
            objArr = newArr;
        }
        objArr[size++] = e;
    }

    /**
     * @return E
     * @Param index={}
     * @description TODO get方法，获取某个元素
     * @date 2019/4/1 10:48
     */
    public E get(int index) {
        checkRange(index);
        return (E) objArr[index];//需要注意返回类型
    }

    /**
     * @return
     * @Param
     * @description TODO set方法，设置某个元素
     * @date 2019/4/1 10:49
     */
    public void set(int index, E e) {
        checkRange(index);
        objArr[index] = e;
    }

    /**
     * @return void
     * @Param index={}
     * @description TODO 数组越界的判断，如果越界则抛出异常。
     * @date 2019/4/1 10:58
     */
    private void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("" + index);
        }
    }

    /**
     * @return void
     * @Param
     * @description TODO remove方法，删除指定元素
     * @date 2019/4/1 11:38
     */
    public void remove(E e) {
        /*遍历比较（通过equals实现），然后删除相同元素*/
        for (int i = 0; i < size; i++) {
            if (e.equals(get(i))) {
                remove(i);
            }
        }
    }

    /**
     * @return void
     * @Param
     * @description TODO remove重载，删除指定位置的元素
     * @date 2019/4/1 11:38
     */
    public void remove(int index) {
        checkRange(index);
        /*remove方法通过arraycopy来实现，将remove位置后面元素，往前复制*/
        System.arraycopy(objArr, index + 1, objArr, index, objArr.length - (index + 1));
        /*remove后，数组最后一个元素应该设置为null*/
        objArr[size - 1] = null;
        /*size应该自减一次*/
        size--;
    }

    /**
     * @return int
     * @Param
     * @description TODO size方法，用来访问ArrayList的size,成员变量size是private
     * @date 2019/4/1 11:50
     */
    public int size() {
        return size;
    }

    /**
     * @return boolean
     * @Param
     * @description TODO isEmpty，判断容器是否为空
     * @date 2019/4/1 11:54
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    /**
     * @Param
     * @description TODO 重写toString
     * @date 2019/4/1 9:45
     * @return java.lang.String
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(objArr[i] + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        DIYArrayList<Integer> d1 = new DIYArrayList();
        /*遍历添加元素*/
        for (int i = 1; i <= 20; i++) {
            d1.add(i);
        }
        /*设置第20个元素为100*/
        d1.set(19, 100);
        /*获取第20个元素*/
        System.out.println(d1.get(19).toString());//100
        System.out.println(d1);//[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,100]
        /*remove容器中值为100的元素*/
        d1.remove(new Integer(100));
        /*remove第一个元素*/
        d1.remove(0);
        /*经过remove后的打印结果*/
        System.out.println(d1);//[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]
        /*获得size的值*/
        System.out.println(d1.size());//18
        /*判断是否为空*/
        System.out.println(d1.isEmpty());//false
    }
}
