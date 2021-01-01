package exception;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
异常处理：抓抛模型


过程1：抛：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象，并将此对象抛出
一旦抛出对象以后，其后的代码就不再执行

过程2：抓：可以理解为异常的处理方式 1、try-catch-finally
2、throws + 异常类型

try{
    可能出现异常的代码
}catch(异常类型1 变量名1){
    异常处理方式1
}catch(异常类型2 变量名2){
    异常处理方式2
}finally{
    一定会执行的代码
}
 */
public class ExceptionTest1 {
    public static void main(String[] args) {
        ExceptionTest1 exce = new ExceptionTest1();
        System.out.println(exce.test1());
    }

    public int test1() {
        try{
            int a = 10;
            int b = 0;
            System.out.println(a / b);
            return 1;
        }catch (ArithmeticException e){
            e.printStackTrace();
            return 2;
        }finally{
            System.out.println("Hello");
            return 3;
        }
    }

    @Test
    public void test2() throws IOException {
        FileInputStream fis = null;
        try{
            File file = new File("Hello.txt");
            fis = new FileInputStream(file);

            int data = fis.read();
            while(data != -1){
                System.out.println((char) data);
                data = fis.read();
            }
            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis != null){
                fis.close();
            }
        }

    }
}

