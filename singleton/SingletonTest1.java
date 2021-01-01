package singleton;

/*
单例设计模式（饿汉式）
一开始就创建一个对象
 */
public class SingletonTest1 {
    public static void main(String[] args){
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1 == bank2);
    }
}


class Bank{
    private Bank(){

    }

    private static Bank instance = new Bank();

    public static Bank getInstance(){
        return instance;
    }
}