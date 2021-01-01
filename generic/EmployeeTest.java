package generic;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/16 17:25
 */
public class EmployeeTest {
    @Test
    public void test1(){
        TreeSet<Employee> set = new TreeSet();
        set.add(new Employee("刘德华", 20, new MyDate(2000, 3, 4)));
        set.add(new Employee("郭富城", 45, new MyDate(1975, 6, 12)));
        set.add(new Employee("黎明", 21, new MyDate(1999, 8, 3)));
        set.add(new Employee("张学友", 20, new MyDate(2000, 11, 6)));
        set.add(new Employee("梁朝伟", 51, new MyDate(1966, 6, 22)));
        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }

    @Test
    public void test2(){
        TreeSet<Employee> set = new TreeSet(new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();
                return b1.compareTo(b2);
            }
        });
        set.add(new Employee("刘德华", 20, new MyDate(2000, 3, 4)));
        set.add(new Employee("郭富城", 45, new MyDate(1975, 6, 12)));
        set.add(new Employee("黎明", 21, new MyDate(1999, 8, 3)));
        set.add(new Employee("张学友", 20, new MyDate(2000, 11, 6)));
        set.add(new Employee("梁朝伟", 51, new MyDate(1966, 6, 22)));

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }
}


class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}


class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        int minusYear = this.year - o.year;
        if(minusYear != 0){
            return minusYear;
        }
        int minusMonth = this.month - o.month;
        if(minusMonth != 0){
            return minusMonth;
        }
        return (this.day - o.day);
    }
}

