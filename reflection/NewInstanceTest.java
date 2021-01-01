package reflection;

import org.junit.Test;

import java.util.Random;

/**通过反射创建对应的运行时类的对象
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/22 16:10
 */
public class NewInstanceTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        /*
        newInstance()调用此方法创建对应的运行时类的对象。内部调用了运行时类的空参构造器
        要想此方法正常创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参构造器的需要可以访问

        在javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类，默认调用supper()时，保证父类有此构造器
         */
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    //体会反射的动态性
    @Test
    public void test2(){
        int num = new Random().nextInt(3);
        String classPass = "";
        switch(num){
            case 0:
                classPass = "java.util.Date";
                break;
            case 1:
                classPass = "java.sql.Date";
                break;
            case 2:
                classPass = "reflection.Person";
                break;
        }

        try {
            Object obj = getInstance(classPass);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    此方法创建一个指定类的对象
    classPath:指定类的全类名
     */
    public Object getInstance(String classPass) throws Exception {
        Class<?> clazz = Class.forName(classPass);
        return clazz.newInstance();
    }
}
