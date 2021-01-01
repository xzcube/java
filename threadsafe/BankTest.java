package threadsafe;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */

public class BankTest {
}


class Bank implements Runnable{
    private void Bank(){

    }

    private static Bank instance = null;  // instance是共享数据，后续有对共享数据的操作，存在线程安全的问题

    @Override
    public void run() {

    }

    public static Bank getInstance(){
        if(instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
