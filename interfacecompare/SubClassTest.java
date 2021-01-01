package interfacecompare;

public class SubClassTest {
    public static void main(String[] args) {
        SubClass s = new SubClass();
        s.method2();
        CompareA.method1();
        s.method3();
    }
}

class SubClass implements CompareA,CompareB{

    @Override
    public void method3() {
        System.out.println("class:广州");
    }

    public void myMethod(){
        CompareB.super.method3();
    }
}
