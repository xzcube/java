package object2.Customer;

import java.util.Objects;

public class Customer {
    int age;
    String name;

    public Customer() {
    }

    public Customer(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Customer){
            Customer cust = (Customer) obj;
            if(this.age == cust.age && this.name.equals(cust.name));
            return true;
        }
        return false;
    } */

    //自动生成的equals()方法

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
