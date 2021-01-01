package generic;

import org.junit.Test;

import java.util.*;

/**泛型的使用
 * jdk 1.5新增的特性
 * 集合接口或集合类在jdk5.0之后都修改为带泛型的结构
 * 在实例化集合类时，可以指明具体的泛型类型
 * 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（方法，构造器，属性）使用到类的泛型的位置，都指定为实例化的泛型类型
 * 比如 add(E e) ---> 实例化以后：add(Integer e)
 * 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，用包装类替换
 * 如果实例化时，没有指明泛型类型，默认类型为Object类型
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/16 16:52
 */
public class GenericTest {
    //在集合中使用泛型之前的情况：
    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(82);
        list.add(89);
        list.add(97);
        list.add(78);
        list.add("Tom");

        for(Object obj : list){
            int score = (int)obj;
            System.out.println(score);
        }
    }

    //在集合中使用泛型之前的情况
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(82);
        list.add(89);
        list.add(97);
        list.add(78);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Tom", 80);
        map.put("Jerry", 90);
        map.put("Jack", 89);
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "---->" + value);
        }
    }

    @Test
    public void test4(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 123);
        map.put("Jerry", 456);
        Set setEntry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = setEntry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String str = entry.getKey();
            Integer integer = entry.getValue();
            System.out.println(str + "--->" + integer);
        }
    }

    @Test
    public void test5(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 3, 5};
        //泛型方法在调用时，指明参数类型
        List<Integer> integers = order.copyFromArrayList(arr);
        System.out.println(integers);
    }
}
