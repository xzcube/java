package polymorphic;

public class Man extends Person{
    boolean isSmoking;
    int height;

    public Man(int height){
        this.height = height;
        super.age = 18;
    }

    public void earnMoney(){
        System.out.println("挣钱");
    }

    public void eat(){
        System.out.println("多吃点");
    }

    public void walk(){
        System.out.println("走远点");
    }
}
