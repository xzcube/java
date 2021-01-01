package generic;

import object.Person;
import object.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/16 20:32
 */
public class GenericTest2 {
    /**
     * 1.泛型在继承方面的体现
     * 类A是类B的父类,G<A>和G<B>不具有子父类关系（是并列的）
     * A<G>是B<G>的父类
     *
     * 2.通配符的使用
     * 通配符:?
     * 类A是类B的父类,G<A>和G<B>不具有子父类关系（是并列的）
     * 二者共同的父类是G<?>
     */
    @Test
    public void test1(){
        List<Object> list = new ArrayList<>(3);
        List<String> list1 = new ArrayList<>(3);

        List<?> list2 = null;
        list2 = list;
        list2 = list1;

        GenericTest2.print1(list1);
        GenericTest2.print1(list2);
    }

    @Test
    public void test2(){
        List<?> list1 = null;
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("BB");
        //对于List<?> 就不能向其内部添加数据（除了添加null之外）
        list1 = list;
    }

    @Test
    public void test3(){
        List<? extends Person> list = null;
        List<? super Person> list1 = null;

        List<Student> list2 = null;
        List<Person> list3 = null;
        List<Object> list4 = null;
       list = list3;
    }

    public static void print1(List<?> list){
        Iterator<?> iterator = list.listIterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
