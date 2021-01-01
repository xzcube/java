package object;

public class BankTest{
    public static void main(String[] args){
        Bank bank = new Bank();
        bank.addCustomers("Jane", "Smith");
        bank.addCustomers("闫", "小");
        // 连续操作（"."操作前面的对象必须要有返回值）
        bank.getCustomers(0).setAccount(new Account(2000));
        bank.getCustomers(0).getAccount().withdraw(500);
        double balance = bank.getCustomers(0).getAccount().getBalance();
        System.out.println("客户：" + bank.getCustomers(0).getFirstName() + "账户余额为：" + balance);
        System.out.println(bank.getNumberofCustomers());
    }
}

class Bank {
    private Customer[] customers;  // 存放客户的数组
    private int numberofCustomers; // 记录客户的个数

    // 构造函数
    public Bank(){
        customers = new Customer[10];  // 初始化Customer数组

    }

    //添加客户
    public void addCustomers(String f, String l){
        Customer cust = new Customer(f, l);
        customers[numberofCustomers] = cust;
        numberofCustomers++;
    }

    //获取客户的个数
    public int getNumberofCustomers(){
        return this.numberofCustomers;
    }

    //获取指定位置上的客户
    public Customer getCustomers(int index){
        if(index >= 0 && index < numberofCustomers){
                return customers[index];
        }else {
            return null;
        }
    }
}


class Account{
    private double balance;

    public Account(double init_balance){
        this.balance = init_balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amt){
        if(amt > 0){
            balance += amt;
            System.out.println("存钱成功");
        }
    }

    public void withdraw(double amt){
        if(balance >= amt){
            balance -= amt;
            System.out.println("取钱成功");
        }else{
            System.out.println("余额不足");
        }
    }
}

class Customer{
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastname(){
        return this.lastName;
    }

    public Account getAccount(){
        return this.account;
    }

    public void setAccount(Account account){
        this.account = account;
    }
}

