package map;

import org.junit.Test;

import java.util.*;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/15 18:12
 */
public class MapTest {
    @Test
    public void test(){
        HashMap map = new HashMap();
        System.out.println(map);
        map.put(123, "AA");
        map.put(456, "Ab");
        map.put(345, "cc");
        System.out.println(map.remove(345));
        map.clear();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(map);
    }

    @Test
    public void test2(){
        HashMap map = new HashMap();
        map.put(123, "AA");
        map.put(456, "Ab");
        map.put(345, "cc");
        map.put(678, "cc");
        System.out.println(map.get((456)));
        boolean isExist = map.containsKey(123);
        System.out.println(isExist);
        System.out.println(map.containsValue("cc"));
        System.out.println(map.isEmpty());
    }

    @Test
    public void test3(){
        HashMap map = new HashMap();
        map.put(123, "AA");
        map.put(456, "Ab");
        map.put(345, "cc");
        map.put(678, "cc");

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("************");
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }

        System.out.println("*********");
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Map.Entry entry = (Map.Entry)(iterator1.next());
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    @Test
    public void test4(){
        TreeMap map = new TreeMap();
        map.put(new User("Tom", 20), 98);
        map.put(new User("Jerry", 30), 90);
        map.put(new User("Jack", 22), 89);
        map.put(new User("Rose", 18), 97);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Map.Entry entry = (Map.Entry)(iterator1.next());
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    @Test
    public void test5(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.age, u2.age);
                }
                throw new RuntimeException("输入类型不匹配");
            }
        });
        map.put(new User("Tom", 20), 98);
        map.put(new User("Jerry", 30), 90);
        map.put(new User("Jack", 22), 89);
        map.put(new User("Rose", 18), 97);
        System.out.println(map);
        System.out.println("*********");

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Map.Entry entry = (Map.Entry)(iterator1.next());
            System.out.println(entry.getKey() + "--->" + entry.getValue());
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
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User) o;
            int compare = user.name.compareTo(this.name);
            if(compare != 0){
                return compare;
            }else {
                return Integer.compare(user.age, this.age);
            }
        }
        throw new RuntimeException("类型不匹配");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}
