package threadsafe;

/**
 * 实现Runnable接口的方式
 */

public class WindowTest2 {
    public static void main(String[] args) {
        Window1 w = new Window1();
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


class Window1 implements Runnable{
    int ticket = 100;

    @Override
    public void run() {
        while(true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "，卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}