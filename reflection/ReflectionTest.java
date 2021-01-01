package reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/21 20:40
 */
public class ReflectionTest {
    //反射
    @Test
    public void test() throws Exception {
        //1.通过反射创建Person对象
        Class clazz = Person.class;
        Constructor cons  = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());
        //2.通过反射调用指定对象的属性、方法
        Field age = clazz.getDeclaredField("age");
        /*
        关于java.class的理解
        1.类的加载过程：
        程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
        接着使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中，此过程就成为类的加载
        加载到内存中的类我们称之为运行时类，此运行时类就作为Class的一个实例
        Class的实例就对应着一个运行时类
        加载到内存中的运行时类，会缓存一定时间。在此时间内，我们可以通过不同方式来获取此运行时类
         */
    }

    //java Class实例的获取
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一:调用运行时类的属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法 forName(String classPath)
        Class clazz3 = Class.forName("reflection.Person");
        System.out.println(clazz3);

        //方式4：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("reflection.Person");
        System.out.println(clazz4);
    }
}


class Person{
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("我是一个人");
    }

    private String  showNation(String nation){
        System.out.println("我的国籍是" + nation);
        return nation;
    }
}
