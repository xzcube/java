package collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/15 16:46
 */
public class EmployeeTest {
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        set.add(new Employee("刘德华", 20, new MyDate(2000, 3, 4)));
        set.add(new Employee("郭富城", 45, new MyDate(1975, 6, 12)));
        set.add(new Employee("黎明", 21, new MyDate(1999, 8, 3)));
        set.add(new Employee("张学友", 20, new MyDate(2000, 11, 6)));
        set.add(new Employee("梁朝伟", 51, new MyDate(1966, 6, 22)));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test2(){
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    int minusYears = b1.getYear() - b2.getYear();
                    if(minusYears != 0){
                        return minusYears;
                    }
                    int minusMonth = b1.getMonth() - b2.getMonth();
                    if(minusMonth != 0){
                        return minusMonth;
                    }
                    int minusDay = b1.getDay() - b2.getDay();
                    return minusDay;
                }
                throw new RuntimeException("类型不一致");
            }
        });
        set.add(new Employee("刘德华", 20, new MyDate(2000, 3, 4)));
        set.add(new Employee("郭富城", 45, new MyDate(1975, 6, 12)));
        set.add(new Employee("黎明", 21, new MyDate(1999, 8, 3)));
        set.add(new Employee("张学友", 20, new MyDate(2000, 3, 4)));
        set.add(new Employee("梁朝伟", 51, new MyDate(1966, 6, 22)));
        for(Object obj : set){
            System.out.println(obj);
        }
    }
}


class Employee implements Comparable{
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
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        }
        throw new RuntimeException("类型不匹配");
    }
}


class MyDate{
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
}