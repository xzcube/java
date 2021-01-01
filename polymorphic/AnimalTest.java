package polymorphic;

public class AnimalTest {
    public static void main(String[] args){
        BlackDog.age = 3;
        BlackDog.dogShout();

        BlackDog dog = new BlackDog();
        System.out.println(BlackDog.age);

        System.out.println(BlackDog.color);
    }
}


class BlackDog{
    static int age;
    int legs;
    static String color = "balck";

    public void dog(){
        System.out.println("汪汪汪");
        BlackDog.age = 20;
        this.legs = 4;
    }

    public static void dogShout(){
        System.out.println("汪 汪 汪");
        age = 10;
    }
}
