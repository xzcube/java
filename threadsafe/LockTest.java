package threadsafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三:Lock锁   JDK5.0新增
 */

public class LockTest {
    public static void main(String[] args) {
        Window5 w = new Window5();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}


class Window5 implements Runnable{
    private int ticket = 100;
    //1.实例化ReentranceLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try{
                //2.调用lock方法()锁定
                lock.lock();
                if(ticket > 0){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //3.调用解锁方法
                lock.unlock();
            }
        }
    }
}
