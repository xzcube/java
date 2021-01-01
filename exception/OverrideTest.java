/*
方法重写的规则之一：子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
 */
package exception;

import javax.sound.midi.Soundbank;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OverrideTest {
    public static void main(String[] args) {

    }
}


class Student{
    private int id;
    public void regist(int id) {
        if(id>0)
        {
            this.id=id;

        }
        else
        {
            throw new MyException("不能为负数");
        }
    }

    public static void main(String[] args) {
        try{
            Student s=new Student();
            s.regist(-1);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
