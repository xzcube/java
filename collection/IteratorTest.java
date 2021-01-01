package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/14 19:04
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(new Person(20, "Jerry"));
        col1.add("Tom");
        col1.add("Tom");

        System.out.println(col1);

        Iterator iterator = col1.iterator();

        while (iterator.hasNext()){
            if(iterator.next().equals("Tom")){
                iterator.remove();
            }
        }

        //将游标指回文件开头
        Iterator iter = col1.iterator();
        System.out.println(col1);
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
