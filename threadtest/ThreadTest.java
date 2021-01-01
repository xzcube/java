package threadtest;

public class ThreadTest {
    public static void main(String[] args) {
        //4.创建上面自定义类的对象
        MyThread mt = new MyThread();
        //5.调用start方法启动线程
        mt.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("xx");
        }
    }

}


class MyThread extends Thread{
    //2.重写run方法
    @Override
    public void run() {
        //3.将要在线程中执行的代码编写在run方法中
        for(int i = 0; i < 1000; i++) {
            System.out.println("wpb");
        }
    }
}

