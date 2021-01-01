package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/16 19:13
 */
public class Order<T> {
    String orderName;
    int orderId;
    //类的内部就可以使用类的泛型
    T orderT;
    public Order(){
        T[] arr = (T[]) new Object[10];
    }

    //泛型方法：在方法中出现了泛型结构，泛型参数与类的泛型参数没有任何关系
    //换句话说，泛型方法与所属类是不是泛型类没有关系
    //泛型方法可以声明成静态的，原因：泛型参数是在调用方法时确定的，不是在实例化时确定的
    public <E>List<E> copyFromArrayList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e : arr){
            list.add(e);
        }
        return list;
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
}
