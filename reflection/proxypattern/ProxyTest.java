package reflection.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**动态代理举例
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/23 15:14
 */
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        //当通过代理类对象调用方法时，会自动调用被代理类中的同名方法
        System.out.println(belief);
        proxyInstance.eat("火锅");
    }
}


interface Human{
    String getBelief();
    void eat(String food);
}


//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}


class HumanUtil{
    public void method1(){
        System.out.println("___________通用方法1____________");
    }

    public void method2(){
        System.out.println("___________通用方法2___________");
    }
}


/*
要想实现动态代理，需要解决的问题
1.如何根据加载到内存中的被代理类，动态创造一个代理类及其对象
2.当通过代理类对象调用方法时，如何动态地去调用被代理类中同名的方法
 */

//通过Proxy类中的静态方法newProxyInstance()创造一个代理类的对象
class ProxyFactory{
    //调用此方法返回一个代理类的对象（解决问题1）
    public static Object getProxyInstance(Object obj){//obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}


class MyInvocationHandler implements InvocationHandler {

    private Object obj; // 需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    /**当我们通过代理类的对象，调用方法a时，就会自动调用如下方法：invoke()
     * 将被代理类要执行的方法a的功能声明在invoke方法中
     *
     * @param proxy 代理类的对象
     * @param method 代理类对象所调用的方法
     * @param args 同名方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil util = new HumanUtil();
        util.method1();
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj：被代理类的对象
        Object returnValue = method.invoke(obj, args);
        //上述方法的返回值就作为当前类中invoke()方法中的返回值
        util.method2();
        return returnValue;
    }
}
