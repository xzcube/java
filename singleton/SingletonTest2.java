package singleton;
/*
单例设计模式（懒汉式）
什么时候用，什么时候创建对象
 */

public class SingletonTest2 {
   public static void main(String[] args){

   }
}


class Order{
    private Order(){

    }

    private static Order intance = null;

    public static Order getInstance(){
        if(intance == null){
            intance = new Order();
        }
        return intance;
    }
}
