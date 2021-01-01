package ioflow;

import org.junit.Test;

import java.io.*;

/**缓冲流：
 * 可以提高流的读取和写入速度
 * 原因：内部提供了一个缓冲区
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/17 21:03
 */
public class BufferedTest {
    @Test
    public void BufferedStreamTese() {
        //造文件
        File srcFile = new File("智乃.jpg");
        File desFile = new File("兔子.jpg");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            //造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //复制的细节：读取，写入
            byte[] buffer = new byte[1024];
            int len = bis.read(buffer);
            while(len != -1){
                bos.write(buffer, 0, len);
                len = bis.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            //要求先关闭外层的流，再关闭内层的流（在关闭外层流的同时，内层流也会自动地进行关闭，因此内层流的关闭可以省略）
            if(bis != null)
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    综合使用InputStreamReader和OutPutStreamWriter
     */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("hellogbk.txt");

        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis);
            osw = new OutputStreamWriter(fos);

            char[] cbuf = new char[20];
            int len;
            while((len = isr.read(cbuf)) != -1){
                osw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(osw != null)
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(isr != null)
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4(){
        for (int i = 0; i < 255; i++) {
            System.out.print((char) i);
            if(i %50 == 0){
                System.out.println();
            }
        }
    }
}
