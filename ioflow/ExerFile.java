package ioflow;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/17 9:06
 */
public class ExerFile {
    @Test
    public void test1() throws IOException {
        File file = new File("D:\\JavaCode\\Study\\io\\hello.txt");
        File file1 = new File(file.getParent(), "haha.txt");
        boolean newFile = file1.createNewFile();
        if(newFile){
            System.out.println("文件创建成功");
        }
    }

    @Test
    public void test2(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 20);
        map.put("Jerry", 30);
        map.put("Jack", 25);
        Set<String> keySet = map.keySet();
        for(String str : keySet){
            System.out.println(str);
        }

        System.out.println("********");
        Collection<Integer> values = map.values();
        for(Integer value : values){
            System.out.println(value);
        }

        System.out.println("**********");
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "--->" + value);
        }
    }

    //图片的加密
    @Test
    public void test3(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("智乃.jpg");
            fos = new FileOutputStream("兔子.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1){
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Test
    public void test4(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("兔子.jpg");
            fos = new FileOutputStream("智乃与兔子.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1){
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
