package polymorphic;

public class Woman extends Person{
    boolean isBeauty;

    public void goShopping(){
        System.out.println("购物");
    }

    public void eat(){
        System.out.println("少吃点");
    }

    public void walk(){
        System.out.println("多运动");
    }
}
