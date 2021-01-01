package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * jdk 5.0之后新增了foreach 循环迭代访问 Collection和数组。
 * @author ：xzcube
 * @date ：Created in 2020/12/14 19:33
 */
public class ForTest {
    @Test
    public void test1(){
        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(new Person(20, "Jerry"));
        for(Object obj : col1){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1, 2, 4, 5, 3};
        for(int i : arr){
            System.out.println(i);
        }

        Collection col2 = new LinkedList();
    }
}
