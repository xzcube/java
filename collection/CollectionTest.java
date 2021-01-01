package collection;

import org.junit.Test;

import java.util.*;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/14 15:16
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new String("Tom"));
        coll.add(new Person(20, "Jerry"));
        coll.add(false);
        System.out.println(coll.size());
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person(20, "Jerry")));
        Collection col2 = Arrays.asList("AA", 123);
        System.out.println(coll.containsAll(col2));
    }

    @Test
    public void Test2(){
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Person(20, "Jerry"));
        System.out.println(coll.remove(1));
        System.out.println(coll);
        coll.remove(new Person(20, "Jerry"));
        System.out.println(coll);
        Collection col1 = Arrays.asList(123, "AA", 456);
        System.out.println(coll.retainAll(col1));
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(new Person(20, "Jerry"));

        Collection col2 = new ArrayList();
        col2.add(123);
        col2.add(456);
        col2.add(123);
        col2.add(new Person(20, "Jerry"));
        System.out.println(col2.equals(col1));
        System.out.println(col2);
    }

    @Test
    public void test4(){
        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(new Person(20, "Jerry"));
        System.out.println(col1.hashCode());
        Object[] objects = col1.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        List<String> strings = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(strings);
        List arr = Arrays.asList(123, 456);
        System.out.println(arr);
    }
}


class Person{
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

}