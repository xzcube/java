package account;

/**
 * 创建 Account 类的一个子类 CheckAccount 代表可透支的账户，该账户中定义一个属性
 * overdraft 代表可透支限额。在 CheckAccount 类中重写 withdraw 方法，其算法如下：
 * 如果（取款金额<账户余额），
 * 可直接取款
 * 如果（取款金额>账户余额），
 * 计算需要透支的额度
 * 判断可透支额 overdraft 是否足够支付本次透支需要，如果可以
 * 将账户余额修改为 0，冲减可透支金额
 * 如果不可以
 * 提示用户超过可透支额的限额
 */

public class CheckAccount extends Account{
    private double overDraft;  // 可透支余额

    public CheckAccount(int id, double balance, double annualInterestRate, double overDraft){
        super(id, balance, annualInterestRate);
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }

    public void withdraw(double amount){
        if(getBalance() >= amount){ //余额足够消费的情况
            //方式一：
//          setBalance(getBalance() - amount);
            //方式二：
            super.withdraw(amount);
        }else if(overDraft >= (amount - getBalance())){ //透支余额 + 余额足够消费
            overDraft -= (amount - getBalance());
            //方法一：
            setBalance(0);
            //方法二
//          super.withdraw(getBalance);
        }else {
            System.out.println("超过可透支限额!");
        }
    }
}
