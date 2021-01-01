package threadtest;

/**
 * 测试Thread中常用的方法
 * 1.start()：启动当前线程；调用当前线程的run()
 * 2.run()：需要重写Thread中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName()：获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前cpu的执行权（但有可能下一刻又分配到cpu的执行权）
 * 7.join():在线程A中调用线程B的join()方法，此时线程A进入阻塞状态，直到线程B完全执行完毕，线程A才结束阻塞状态
 * 8:sleep(long millitime):让当前线程“睡眠”指定millitime毫秒，在指定的时间内，当前线程是阻塞状态
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread t1 = new HelloThread("线程1");
        t1.setName("线程一");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        Thread.currentThread().setName("主线程");

        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" +
                        Thread.currentThread().getPriority() + "," + i);
            }
        }
        System.out.println(t1.isAlive());
    }
}


class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    public HelloThread(String name){
        super(name);
    }
}
