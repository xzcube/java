package object;

public class Person {
    String name;
    int age;
    int id = 1001;  // 身份证号

    public Person(){

    }

    public Person(String name){
        this.name = name;
    }

    public Person(String name, int age) {
        this(name);
        this.age = age;
    }

    public void eat(){
        System.out.println("吃饭");
    }

    public void sleep(){
        System.out.println("睡觉");
    }

    public void setAge(int age){
      this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void walk(int distance){
        System.out.println("走了" + "距离的路");
    }
}



