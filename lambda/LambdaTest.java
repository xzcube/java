package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**Lambda表达式的使用
 *
 * 1.举例：(o1, o2) -> Integer.compare(o1, o2);
 * 2.格式：
 *      ->:Lambda操作符 或 箭头表达式
 *      左边：lambda形参列表（其实就是接口中的抽象方法的形参列表）
 *      右边：lambda体（其实就是重写的抽象方法的方法体）
 *
 * 4.Lambda表达式的本质：作为接口的实例（也就说lambda表达式是借助于接口存在的）
 * 总结：
 *      ->左边：lambda形参列表,类型可以省略；如果只有一个参数，()可以省略；若没有参数或有两个机以上的参数，不能省略()
 *      ->右边：lambda体,应该使用{}包裹，如果只有一条执行语句（可能是return语句），可以省略{}与return关键字
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/24 10:16
 */
public class LambdaTest {
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();
        System.out.println("**********");
        Runnable r2 = () -> System.out.println("我爱故宫");
        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);
        System.out.println("**********");
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(23, 13));
    }

    //lambda需要一个参数，但是没有返回值。
    @Test
    public void test3(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("轻音少女");
        System.out.println("**********");
        Consumer<String > con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("上低音号");
    }

    @Test
    public void test4(){
        //数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
        Consumer<String> con = (s) -> {
            System.out.println(s);
        };
        con.accept("冰果");
    }

    @Test
    public void test5(){
        happyTime(500, money -> System.out.println("吃了顿火锅，花费为：" + money));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test6(){
        List<String> list = Arrays.asList("东京", "南京", "北京", "天津", "普京");
        list.stream().filter(e -> e.contains("京")).forEach(System.out::println);
    }

    //根据规则过滤集合中的字符串。此规则由Predicate的方法决定的
    public List<String> filterString(List<String> list, Predicate<String> p){
        ArrayList<String> filterList = new ArrayList<>();
        for(String s : list){
            if(p.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
