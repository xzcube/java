package StreamTest;

import methodreference.Employee;
import methodreference.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**测试Stream中间操作
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/24 21:34
 */
public class StreamTest1 {
    //筛选与切片操作
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        //查询员工表中大于7000的员工信息
        //filter() 接收lambda，从流中排除某些元素
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println("**************");
        Stream<Employee> em = employees.stream();
        //skip(n) 跳过元素，返回一个去除掉前n个元素的流，若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        em.skip(3).forEach(System.out::println);
        System.out.println("************");
        //distinct() 筛选，通过流所生成的HashCode和equals方法，去除重复元素
        Stream<Employee> em2 = employees.stream();
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        em2.distinct().forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("aa", "bb", "cc");
        List<Employee> emp = EmployeeData.getEmployees();
        list.stream().map(str -> str.toUpperCase(Locale.ROOT)).forEach(System.out::println);
        System.out.println("************");
        //emp.stream().filter(e -> e.getName().length() > 3).forEach(System.out::println);
        Stream<String> nameStream = emp.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() > 3).forEach(System.out::println);
        System.out.println("*************");
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest1::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out::println));
        System.out.println("*********");
        //list.stream().flatMap(str -> StreamTest1.fromStringToStream(str)).forEach(c -> System.out.println(c));
        list.stream().flatMap(StreamTest1::fromStringToStream).forEach(System.out::println);
        System.out.println("************");
    }

    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(34, 12, 42, 5, 13);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("*************");
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).forEach(System.out::println);
        System.out.println("*****************");
        employees.stream().sorted((e1, e2) -> {
            int value = Integer.compare(e1.getAge(), e2.getAge());
            if(value != 0){
                return value;
            }else {
                return Integer.compare(e1.getId(), e2.getId());
            }
        }).forEach(System.out::println);

    }


    //将字符串中多个字符集合转换成对应的Stream
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
}
