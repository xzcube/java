package StreamTest;

import methodreference.Employee;
import methodreference.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**Stream的终止操作
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/25 15:41
 */
public class StreamTest2 {
    // 1.匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);
        System.out.println("***********");
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);
        boolean match = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(match);
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
    }

    @Test
    public void test2(){
        List<Employee> list = EmployeeData.getEmployees();
        long count = list.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
        Optional<Double> max = list.stream().map(e -> e.getSalary()).max(Double::compare);
        System.out.println(max);
        Optional<Employee> min = list.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
    }

    //规约
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7 ,8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce);
        System.out.println("********");
    }

    //收集
    @Test
    public void test4(){
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("*********");
        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
    }
}
