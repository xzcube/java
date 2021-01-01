package objectflow;

import java.io.Serializable;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/19 16:31
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -3065878585697088185L;
    private String name;
    private static int age;
    private static String sex = "girl";

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
