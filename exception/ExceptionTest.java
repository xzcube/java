package exception;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;


//运行时异常
public class ExceptionTest {
    @Test
    public void test1(){
        String str = "abc";
        //StringIndexOutOfBoundsException
        System.out.println(str.charAt(3));
    }

    //ClassCastException
    @Test
    public void test2(){
        Object obj = new Date();
        String str = (String) obj;
    }

    //NumberFormatException
    @Test
    public void test3(){
        String str = "abc";
        int num = Integer.parseInt(str);
    }

    //InputMismatchException
    @Test
    public void test4(){
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);
    }

    //ArithmeticException
    @Test
    public void test5(){
        int a = 0;
        int b = 2;
        System.out.println(b / a);
    }
}


//编译时异常
/*
class ExceptionTest2{
    @Test
    public void test6(){
        File file = new File("Hello");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while(data != -1){
            System.out.println((char) data);
            data = fis.read();
        }
        fis.close();
    }
}
 */
