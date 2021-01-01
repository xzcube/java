package polymorphic;

public class PersonTest {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.eat();

        Man man = new Man(30);
        man.eat();
        System.out.println(man.age);
        System.out.println(man.height);

        // 对象的多态性
        Person p2 = new Person();

        p2.eat();

        if(p2 instanceof Man){
            System.out.println("p2是男人");
        }


    }
}
