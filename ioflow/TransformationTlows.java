package ioflow;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReader：将InputStream转换为Reader
 * OutputStreamWriter：将Writer转换为OutputStream
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/17 22:09
 */
public class TransformationTlows {
    @Test
    //将字节的输入流转化为字符的输入流
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("hello.txt");
        InputStreamReader irs = new InputStreamReader(fis);
        char[] cbuf = new char[20];
        int len;
        while((len = irs.read(cbuf)) != -1){
            String str = new String(cbuf, 0, len);
            System.out.println(str);
        }
        irs.close();
    }
}
