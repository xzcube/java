package annotation;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/14 10:08
 */

@SuppressWarnings("Hello")
public class AnnotationTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.age = 10;
        System.out.println(p.age);
    }
}

@MyAnnocation("Hello")
@MyAnnocation("hi")
class Person{
    int age;
    String name;
}
