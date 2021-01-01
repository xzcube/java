package methodreference;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *
 * 二、数组引用
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        sup.get();
        System.out.println("*********");
        Supplier<Employee> sup2 = () -> new Employee();
        sup2.get();
        System.out.println("***********");
        Supplier<Employee> sup3 = Employee::new;
        sup3.get();
	}

	//Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer, Employee> fun1 = id -> new Employee(id);
        Employee apply = fun1.apply(1001);
        System.out.println(apply);
        System.out.println("************");
        Function<Integer, Employee> fun2 = Employee::new;
        System.out.println(fun2.apply(1002));
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer, String, Employee> bf1 = (s1, s2) -> new Employee(s1, s2);
        ;
        Employee emp = bf1.apply(1001, "Tom");
        System.out.println(emp);
        System.out.println("**************");
        BiFunction<Integer, String, Employee> bf2 = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer integer, String s) {
                return new Employee(integer, s);
            }
        };
        System.out.println(bf2.apply(1002, "Jerry"));
        System.out.println("***********");
        BiFunction<Integer, String, Employee> bf3 = Employee::new;
	}

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer, String[]> fun1 = length -> new String[length];
        String[] apply = fun1.apply(5);
        System.out.println(Arrays.toString(apply));
        System.out.println("*************");
        Function<Integer, String[]> fun2 = String[]::new;
        String[] apply2 = fun1.apply(10);
        System.out.println(Arrays.toString(apply2));
    }
}
