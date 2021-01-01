package threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * JDK 5.0 新增的方式
 * 创建新线程的方式三：实现Callable接口的方式
 * 1.创建一个实现了Callable接口的实现类
 * 2.重写Callable接口中的call方法
 * 3.创建Callable接口实现类的对象
 * 4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
 * 5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread类对象，并调用start()方法
 * 6.获取Callable中call方法的返回值
 */

public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);

        new Thread(futureTask).start();
        try {
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class NumThread implements Callable{
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0){
                sum += i;
            }
        }
        return sum;
    }
}
