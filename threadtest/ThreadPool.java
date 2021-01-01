package threadtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        //提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //设置线程池的属性
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);

        //执行指定线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread()); // 适合用于Runnable
//        service.submit(); // 适合用于Callable
        //关闭线程池
        service.shutdown();
    }
}


class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
