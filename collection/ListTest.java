package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/14 20:52
 */
public class ListTest {
    @Test
    public void test1(){
        ArrayList arr = new ArrayList();
        arr.add(123);
        arr.add(456);
        arr.add("AA");
        arr.add(456);
        arr.add(new Person(20, "Tom"));
        System.out.println(arr);
        arr.add(1, "BB");
        System.out.println(arr);
        List list1 = Arrays.asList(1, 2, 3);
        arr.addAll(list1);
        System.out.println(arr.size());
        System.out.println(arr);
        System.out.println(arr.get(1));
        System.out.println(arr.indexOf(456));
        System.out.println(arr.lastIndexOf(456));
        arr.remove(0);
        System.out.println(arr);
        arr.set(0, "CC");
        System.out.println(arr);
        List list = arr.subList(2, 4);
        System.out.println(list);
    }
}
