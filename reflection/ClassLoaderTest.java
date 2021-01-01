package reflection;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/22 11:26
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent():获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        //调用扩展器加载器的getParent():无法获取引导类加载器
        //引导类加载器主要负责加载java核心类库，无法自定义加载
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }

    /*
    Properties:用来读取配置文件
     */
    @Test
    public void test2() throws Exception {
        Properties pro = new Properties();
        //此时文件默认在当前modul下
        //读取配置文件的方式一：
        /*FileInputStream fis = new FileInputStream("jdbc.properties");
        pro.load(fis);
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        System.out.println("user:" + user + ", password:" + password);*/

        //读取配置文件的方式二
        //配置文件默认识别为：当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pro.load(is);
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        System.out.println("user:" + user + ", password:" + password);
    }
}
