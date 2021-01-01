package reflection;

import org.junit.Test;

import java.lang.reflect.Method;

/**获取运行时类的方法结构
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/22 17:52
 */
public class MethodTest {
    @Test
    public void test1(){
        Class clazz = Person.class;
        //getMethod():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method f : methods) {
            System.out.println(f);
        }
    }

    @Test
    public void test2(){
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
    }
}
