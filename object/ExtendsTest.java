package object;

public class ExtendsTest {
    public static void main(String[] args){

        Student s1 = new Student("小闫", 19, "画画");
        s1.name = "haha";
        System.out.println(s1.getClass().getSuperclass());
        s1.setAge(12);
        System.out.println("年龄是：" + s1.getAge());
        s1.eat();
        s1.show();
        Person p1 = new Person();
    }
}
