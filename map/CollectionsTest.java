package map;

import org.junit.Test;

import java.util.*;

/**
 * Collection:操作Collection与Map的工具类
 * Collection与Collections的区别：
 *      Collection 是一个集合接口（集合类的一个顶级接口）。它提供了对集合对象进行基本操作的通用接口方法。
 *      Collection接口在Java 类库中有很多具体的实现。
 *      Collection接口的意义是为各种具体的集合提供了最大化的统一操作方式，其直接继承接口有List与Set。
 *
 *      Collections则是一个操作 Set、List 和 Map 等集合的工具类，其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。
 *
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/16 10:20
 */
public class CollectionsTest {
    /*reverse(List)：反转 List 中元素的顺序
    shuffle(List)：对 List 集合元素进行随机排序
    sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
    sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
    swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换*/
    @Test
    public void test(){
        List list = new ArrayList();
        list.add(123);
        list.add(34);
        list.add(29);
        list.add(75);
        list.add(29);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(list);
        System.out.println(Collections.max(list));
        System.out.println(Collections.frequency(list, 29));
    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(34);
        list.add(29);
        list.add(75);
        list.add(29);

        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);

        List list1 = Collections.synchronizedList(list);
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入十个数字:");
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextInt());
        }
        System.out.println("原列表为：" + list);
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return -i1.compareTo(i2);
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        System.out.println("倒序后的列表为:" + list);

    }

    @Test
    public void test3(){
        int[] arr = new int[]{1, 3, 45, 30};
        List ints = Arrays.asList(arr);
        System.out.println(ints);

        List list = new ArrayList();
        list.add(1);
        list.add("asdf");
        list.add(true);
        System.out.println(list);
    }

}

