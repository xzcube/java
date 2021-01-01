package object2.Customer;

public class CustomerTest {
    public static void main(String[] args){
        Customer cust1 = new Customer(30, " Tom");
        Customer cust2 = new Customer(30, "Tom");
        System.out.println(cust1.equals(cust2));
        System.out.println(cust1.toString());
    }
}
