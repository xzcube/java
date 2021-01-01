package ioflow;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/17 20:13
 */
public class FileInputOutStream {

    @Test
    public void test1()  {
        File file = new File("智乃.jpg");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            byte[] buffer = new byte[5];
            int len = fis.read(buffer);

            while(len != -1){
                String str = new String(buffer, 0, len);
                System.out.print(str);
                len = fis.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        long start = System.currentTimeMillis();
        copyFile("智乃.jpg", "兔子.jpg");
        long end = System.currentTimeMillis();
        System.out.println("复制所用的时间为" + (end - start));
    }

    public void copyFile(String srcPath, String desPath){
        File file1 = new File(srcPath);
        File file2 = new File(desPath);

        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            fr = new FileInputStream(file1);
            fw = new FileOutputStream(file2);

            byte[] bytes = new byte[1024];
            int len = fr.read(bytes);
            while(len != -1){
                fw.write(bytes);
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
