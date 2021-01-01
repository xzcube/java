package exception;
/*
自定义异常类型：
1.继承于现有的异常结构:RuntimeExcption,Exception
2.提供全局常量 serialVersionUID
3.提供重载的构造器
 */
public class MyException extends RuntimeException{
    static final long serialVersionUID = -70348971907457663L;
    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }
}
