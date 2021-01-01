package interfacetest;

import javafx.print.Printer;

public class USBTest {
    public static void main(String[] args) {
        Computer comp = new Computer();
        //创建了接口的非匿名实现类的非匿名对象
        Flash flash = new Flash();
        comp.transferDate(flash);

        //创建结构的非匿名实现类的匿名对象
        comp.transferDate(new Print());

        //创建接口的匿名实现类的非匿名对象
        USB phone = new USB(){

            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("手机结束工作");
            }
        };
        comp.transferDate(phone);

        //创建了接口的匿名实现类的匿名对象
        comp.transferDate(new USB() {
            @Override
            public void start() {
                System.out.println("mp3开始工作");
            }

            @Override
            public void stop() {
                System.out.println("mp3结束工作");
            }
        });
    }
}


interface USB{
    //常量定义了长宽尺寸，最大，最小传输速度等
    public static final double MAX_SPEED = 100;
    double WIDE = 3;
    double HEIGHT = 0.5;
    double MIN_SPEED = 10;

    public abstract void start();

    void stop();
}


class Computer{
    public void transferDate(USB usb){
        usb.start();
        System.out.println("具体传输数据细节");
        usb.stop();
    }
}


class Flash implements USB{

    @Override
    public void start() {
        System.out.println("u盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("u盘停止工作");
    }
}


class Print implements USB{

    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机停止工作");
    }
}
