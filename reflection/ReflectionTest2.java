package reflection;

import org.junit.Test;
import reflection.person.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**调用运行时类指定的结构：属性，方法
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/23 9:04
 */
public class ReflectionTest2 {
    /*

     */
    @Test
    public void testField() throws Exception{
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //获取指定的属性(要求运行时类的属性声明为public的)
        Field id = clazz.getField("id");

        /*
        设置当前的属性值
        set()参数1：指明设置哪个对象的属性    参数2：将此属性设置为多少
         */
        id.set(p, 1001);

        /*
        获取当前属性的值
        get():参数1：获取哪个对象的当前属性值
         */
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    /*
    如何操作运行时类的指定属性
     */
    @Test
    public void test2() throws Exception{
        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        //保证当前属性是可访问的。
        name.setAccessible(true);  //它提供了将反射的对象标记为在使用时取消默认 Java 语言访问控制检查的能力
        //获取、设置指定对象的此属性值
        name.set(p, "Tom");
        System.out.println(name.get(p));
    }

    /*
    操作运行时类的指定方法
     */
    @Test
    public void test3() throws Exception{
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        /*
        获取指定的某个方法
        getDeclaredMethod():参数1：指明获取的方法名称;参数2：指明获取方法的形参列表
         */
        Method show =  clazz.getDeclaredMethod("show", String.class);

        //保证是可访问的
        show.setAccessible(true);

        /*
        invoke():参数1：调用的对象；参数二：实参
        该方法的返回值即为对应类中调用方法的返回值
         */
        String chn = (String) show.invoke(p, "CHN");
        System.out.println(chn);

        System.out.println("*******调用静态方法********");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object invoke = showDesc.invoke(Person.class);
        //如果调用的运行时类的方法没有返回值，则invoke()方法的返回值是null;
        System.out.println(invoke);
    }
}
