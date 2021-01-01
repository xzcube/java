package reflection;

import org.junit.Test;
import reflection.person.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/22 17:33
 */
public class FieldTest {

    //获取属性结构
    @Test
    public void test(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            //1.获取权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String fName = f.getName();
            System.out.println(fName);
            System.out.println();
        }
    }

    //获取运行时类带泛型的父类的泛型
    @Test
    public void test2(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }

    //获取运行时类实现的接口
    @Test
    public void test3(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();

        for (Class c : interfaces){
            System.out.println(c);
        }
        System.out.println("*******");
        //获取运行时类父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(interfaces1);
        }
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test4() throws ClassNotFoundException {
        Class clazz = Class.forName("reflection.person.Person");
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /*
    获取运行时类声明的注解
     */
    @Test
    public void test5(){
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }
    }
}
