package collection;

import org.junit.Test;

import java.util.*;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/15 8:52
 */
public class SetTest {
    @Test
    public void test1(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add(new Person(20, "Jerry"));
        set.add(new User("Tom", 20));
        set.add(new User("Tom", 20));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        TreeSet set = new TreeSet();
        set.add(new User("Tom", 20));
        set.add(new User("Jerry", 30));
        set.add(new User("Jack", 50));
        set.add(new User("小闫", 19));
        set.add(new User("Jack", 40));
        System.out.println(set);
    }

    @Test
    public void test3(){
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.age, u2.age);
                }
                throw new RuntimeException("类型不匹配");
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("Tom", 20));
        set.add(new User("Jerry", 30));
        set.add(new User("Jack", 50));
        set.add(new User("小闫", 19));
        set.add(new User("Jack", 30));

        Iterator iter = set.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}


class User implements Comparable{
    String name;
    int age;

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User u = (User) o;
            int compare = this.name.compareTo(u.name);
            if(compare != 0){
                return compare;
            }else {
                return Integer.compare(this.age, u.age);
            }
        }
        throw new RuntimeException("类型不匹配");
    }
}
