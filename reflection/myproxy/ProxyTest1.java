package reflection.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/23 21:23
 */
public class ProxyTest1 {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human superProxy = (Human) ProxyFactory.getProxy(superMan);
        superProxy.eat("火锅");
        String belief = superProxy.getBelief();
        System.out.println(belief);
        System.out.println("***********");
        BatMan batMan = new BatMan();
        Human batProxy = (Human) ProxyFactory.getProxy(batMan);
        System.out.println(batProxy.getBelief());
        batProxy.eat("烧烤");
    }
}


interface Human{
    String getBelief();
    void eat(String food);
}


class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("超人喜欢吃" + food);
    }
}


class BatMan implements Human{

    @Override
    public String getBelief() {
        return "民风淳朴哥谭市";
    }

    @Override
    public void eat(String food) {
        System.out.println("蝙蝠侠喜欢吃" + food);
    }
}


class ProxyFactory{
    public static Object getProxy(Object obj){
        EnProxy h = new EnProxy();
        h.setObj(obj);
        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), h);
        return o;
    }
}


class EnProxy implements InvocationHandler {

    private Object obj;

    public void setObj(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(obj, args);
        return invoke;
    }
}