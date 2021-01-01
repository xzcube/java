package StreamTest;

import methodreference.Employee;
import methodreference.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**Stream执行流程：
 * 1.stream实例化
 * 2.一系列中间操作（过滤、映射、..）
 * 3.终止操作
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/24 20:37
 */

//测试Stream实例化
public class StreamAPITest {

    //创建Stream的方式1：通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream(); // 返回一个顺序流
        Stream<Employee> stream1 = employees.parallelStream(); // 返回一个并行流
    }

    //方式2：通过数组
    @Test
    public void test2(){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);
        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(10021, "Jerry");
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //方式3：通过Stream的of()
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }

    //方式4：创建无限流
    @Test
    public void test4() {
        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        System.out.println("************");
        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
