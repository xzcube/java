package object2;
import object.BankTest;
import java.util.Scanner;

public class PackageImportTest {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println("编号为:" + number);
    }
}
