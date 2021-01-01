package ioflow;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类
 * 操作数据单位：字节流、字符流
 * 数据流向：输入流、输出流
 * 流的角色：节点流、处理流
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/17 15:36
 */
public class FileReaderWriterTest {

    /*
    将 hello.txt文件中的内容读入程序中，并输出到控制台
    说明点:1.read():返回读入的一个字符，如果达到文件结尾，返回-1
          2.为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally进行异常处理
          3.读入的文件一定要存在，否则就会报FileNotFoundException
     */
    @Test
    public void testFileReader() {
        //1.实例化File对象，指明要操作的文件
        File file = new File("hello.txt");
        //2.提供具体的流
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            //3.数据的读入
            //read():返回读入的一个字符，如果达到文件结尾，返回-1
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReader2() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            //读入操作的升级（返回每次读入数组中字符的个数，如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len = fr.read(cbuf);
            while (len != -1) {
                //方法一：
                /*for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }*/

                //方法二：
                String str = new String(cbuf, 0, len);
                System.out.print(str);
                len = fr.read(cbuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileWriter() {
        /*
        从内存中写出数据到硬盘里
        1.输出操作，对应的文件可以不存在，如果不存在，会自动创建文件
        2.如果存在：
            1）如果流使用的构造器是FileWriter fw = new FileWriter(file)/FileWriter fw = new FileWriter(file, false)
            则会覆盖原有文件
            2）如果流使用的构造器是FileWriter fw = new FileWriter(file, true),则不会覆盖原有文件，而是在后面继续写
         */
        //1.提供File类对象，指明要写入到的文件
        File file = new File("hello1.txt");
        FileWriter fw = null;

        try {
            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file);

            //3.写出的操作
            fw.write("I have a dream!\n");
            fw.write("you have a dream too");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭
            if(fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReaderFileWriter() {
        //1.创建File类对象，指明读入和写出的文件
        File scrFile = new File("hello.txt");
        File desFile = new File("hello2.txt");

        //2.创建输入和输出流的对象
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            fr = new FileInputStream(scrFile);
            fw = new FileOutputStream(desFile);

            //3.数据的读入和写出操作
            byte[] cbuf = new byte[5];
            int len = fr.read(cbuf);
            while (len != -1){
                fw.write(cbuf, 0, len);
                len = fr.read(cbuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReaderFileWriter2() {
        File file1 = new File("智乃.jpg");
        File file2 = new File("兔子.jpg");

        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            fr = new FileInputStream(file1);
            fw = new FileOutputStream(file2);

            byte[] bytes = new byte[100];
            int len = fr.read(bytes);
            while(len != -1){
                fw.write(bytes, 0, len);
                len = fr.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
