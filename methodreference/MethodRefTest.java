package methodreference;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用:当传递给Lambda体的操作，已经有实现方法了，可以使用方法引用
 * 2.本质上就是lambda表达式
 * 3.使用格式  类（对象）::方法名
 * 4.方法引用使用要求：要求接口中的抽象方法形参列表和返回值类型与方法引用方法的形参列表和返回值类型相同
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> con1 = str -> System.out.println(str);
		con1.accept("北京");
		System.out.println("*****************");
		PrintStream ps = System.out;
		Consumer<String> con2 = ps::println;
		con2.accept("天津");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1001, "Tom", 23, 8900);
		Supplier<String> sup1 = () -> emp.getName();
		System.out.println(sup1.get());
		System.out.println("***********");
		Supplier<String> sup2 = emp :: getName;
		System.out.println(sup2.get());
	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
		System.out.println(com1.compare(12, 34));
		System.out.println("***********");
		Comparator<Integer> com2 = Integer :: compare;
		System.out.println(com2.compare(12, 3));
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double, Long> fun1 = d -> Math.round(d);
		System.out.println(fun1.apply(12.3));
		System.out.println("***************");
		Function<Double, Long> fun2 = Math::round;
		System.out.println(fun2.apply(12.6));
	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
		int compare = com1.compare("abc", "abd");
		System.out.println(compare);
		System.out.println("*************");
		Comparator<String> com2 = String :: compareTo;
		System.out.println(com2.compare("abc", "abm"));
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String, String> bp1 = new BiPredicate<String, String>() {
			@Override
			public boolean test(String s, String s2) {
				return s.equals(s2);
			}
		};
		System.out.println(bp1.test("hhh", "mmm"));
		System.out.println("************");
		BiPredicate<String, String> bp2 = (s1, s2) -> s1.equals(s2);
		System.out.println(bp2.test("hhh", "hhh"));
		System.out.println("****************");
		BiPredicate<String, String> bp3 = String::equals;
		System.out.println(bp3.test("ooo", "iii"));
		
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee emp = new Employee(1001, "Tom", 23, 8900);
		Function<Employee, String> fun1 = new Function<Employee, String>() {
			@Override
			public String apply(Employee employee) {
				return employee.getName();
			}
		};
		System.out.println(fun1.apply(emp));
		System.out.println("*************");
		Function<Employee, String> fun2 = e -> e.getName();
		System.out.println(fun2.apply(emp));
		System.out.println("***********");
		Function<Employee, String> fun3 = Employee::getName;
		System.out.println(fun3.apply(emp));
	}
}
