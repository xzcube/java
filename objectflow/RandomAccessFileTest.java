package objectflow;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * RandomAccessFile的使用
 * 直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 既可以作为一个输入流，也可以作为一个输出流
 *如果文件不存在，则会创建一个文件，如果文件存在，则会覆盖原有文件（默认从头覆盖，有多少覆盖多少，原有文件其它部分不变）
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/19 21:54
 */
public class RandomAccessFileTest {
    @Test
    public void test1(){
        RandomAccessFile raf = null;
        RandomAccessFile raf2 = null;
        try {
            raf = new RandomAccessFile(new File("hello.txt"), "r");
            raf2 = new RandomAccessFile(new File("hello2.txt"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while((len = raf.read(buffer)) != -1){
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf != null)
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(raf2 != null)
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        raf1.seek(raf1.length()); // 将指针调到角标为3的位置
        raf1.write("xyz".getBytes(StandardCharsets.UTF_8));
        raf1.close();
    }

    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        raf1.seek(3);
        // 保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer, 0, len));
        }
        //调回指针,写入"xyz"
        raf1.seek(3);
        raf1.write("hhh".getBytes(StandardCharsets.UTF_8));
        //将stringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes(StandardCharsets.UTF_8));
        raf1.close();
    }
}
