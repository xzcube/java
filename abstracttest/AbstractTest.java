package abstracttest;

public class AbstractTest {
    public static void main(String[] args) {
        Template t = new SubTemplate();
        t.spendTime();
    }
}


abstract class Template{
    //计算某段代码执行所花费的时间
    public void spendTime(){
        long star = System.currentTimeMillis();
        this.code();

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为:" + (end - star));
    }

    public abstract void code();
}


class SubTemplate extends Template{
    @Override
    public void code() {
        for(int i = 2; i < 100; i++){
            boolean isFlag = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isFlag = false;
                }
            }
            if(isFlag){
                System.out.println(i);
            }
        }
    }
}