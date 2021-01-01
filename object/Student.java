package object;

import java.util.Objects;

public class Student extends Person {
    String major;
    int id = 1002;  // 学号


    public Student() {
    }

    public Student(String major){
        this.major = major;
    }

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public Student(String name, String major, int id) {
        super(name);
        this.major = major;
        this.id = id;
    }

    public Student(String name, int age, String major, int id) {
        super(name, age);
        this.major = major;
        this.id = id;
    }

    public void eat(){
        System.out.println("学生应该吃点好的");
    }

    public void study(){
        System.out.println("学习，专业是" + this.major);
    }

    public void show(){
        System.out.println("姓名:" + this.name + ",年龄:" + this.age);
        System.out.println("id:" + super.id);
        super.eat();
    }
}
