package object;

public class Order {
    private int orderPrivate;
    int orderDefault;
    public int orderPublic;
    protected int orderProtected;

    private void methodPrivate(){
        orderPrivate = 1;
    }

    protected void methodProtected(){
        System.out.println("protected方法");
    }

    public void methodPublic(){
        System.out.println("public方法");
    }
}
