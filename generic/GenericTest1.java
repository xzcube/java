package generic;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/16 19:18
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类为Object类
        //要求；如果定义了类是带泛型的，建议在实例化时要指明类的泛型
        Order<String> order = new Order<String>();
        order.setOrderT("123");
        order.setOrderT("1a");
        Order<String> order1 = new Order<String>("orderAA", 1001, "AA");
        order1.setOrderT("AA:Hello");

    }

    @Test
    public void test2(){
        SubOrder subOrder = new SubOrder();
        //由于子类在继承带泛型的父类的时候，指明了泛型类型，则子类实例化对象时，不需要指明泛型类型
        subOrder.setOrderT(1122);
        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT("1122");
    }

    @Test
    public void test3(){
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
    }

}


class SubOrder extends Order<Integer>{

}


class SubOrder1<T> extends Order<T>{

}
