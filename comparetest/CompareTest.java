package comparetest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：java中的对象，正常情况下，只能进行比较：== 或 ！=。不能使用 > 或 <
 * 但是在开发过程中，我们需要 对多个对象进行排序，即需要比较对象的大小
 * 如何比较两个对象的大小 ：Comparable 或 Comparator
 */

public class CompareTest {
    @Test
    /*
    Comparable使用举例
    1.String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方法
     */
    public void test1() {
        String[] arr = new String[]{"AA", "BB", "CC", "MM", "GG", "DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("联想", 30);
        arr[1] = new Goods("小米", 22);
        arr[2] = new Goods("微软", 50);
        arr[3] = new Goods("华为", 40);
        arr[4] = new Goods("戴尔", 50);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() {
        String[] arr = new String[]{"华为", "联想", "微软", "戴尔", "GG", "DD"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return s2.compareTo(s1);
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4() {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("联想", 30);
        arr[1] = new Goods("小米", 22);
        arr[2] = new Goods("微软", 50);
        arr[3] = new Goods("华为", 40);
        arr[4] = new Goods("戴尔", 50);
        arr[5] = new Goods("华为", 60);

        Comp comp = new Comp();
        Arrays.sort(arr, comp);
        System.out.println(Arrays.toString(arr));
    }
}


class Comp implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Goods && o2 instanceof Goods) {
            Goods g1 = (Goods) o1;
            Goods g2 = (Goods) o2;
            if (g1.getName() == g2.getName()) {
                return g1.compareTo(g2);
            } else {
                return -g1.getName().compareTo(g2.getName());
            }
        }
        throw new RuntimeException("输入类型不匹配");
    }
}
