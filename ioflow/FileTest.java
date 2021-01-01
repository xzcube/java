package ioflow;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**File类的使用
 * 一个File类的对象，代表一个文件或一个文件目录
 * 声明在java.io包下
 *File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 * 并未涉及到写入或读取文件内容的操作。如需要读取或写入文件内容，必须使用IO流来完成
 * 后续File类对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/16 21:49
 */
public class FileTest {
    /*
    如何获取io对象
     */
    @Test
    public void test1(){
        //构造器1
        File file = new File("Hello.txt"); //相对于当前module

    }

    /*
    public String getAbsolutePath()：获取绝对路径
    public String getPath() ：获取路径
    public String getName() ：获取名称
    public String getParent()：获取上层文件目录路径。若无，返回null
    public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
    public long lastModified() ：获取最后一次的修改时间，毫秒值

    如下的两个方法适用于文件目录：
    public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
    public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\io\\hi.txt");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println("***********");
        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    @Test
    public void test3(){
        File file = new File("D:\\JavaCode\\Study\\src");
        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }
    }

    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\JavaCode\\hi");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
    }

    @Test
    public void test5() throws IOException {
        File file = new File("hello.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("文件创建成功");
        }else{
            file.delete();
            System.out.println("文件删除成功");
        }
    }
}
