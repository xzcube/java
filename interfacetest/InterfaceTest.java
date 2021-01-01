package interfacetest;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_Speed);
        System.out.println(Flyable.MIN_SPEED);

    }
}


interface AttackAble{

}

interface Flyable{
    //全局常量
    public static final int MAX_Speed = 7900;
    int MIN_SPEED = 1;

    //抽象方法
    public abstract void fly();
    void stop();
}


class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速，停止");
    }
}


abstract class Kite implements Flyable{

    @Override
    public void fly() {

    }
}


class Bullet implements Flyable, AttackAble, CC{

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}


interface AA{
    void method1();
}


interface BB{
    void method2();
}


interface CC extends AA,BB{

}