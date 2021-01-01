package map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/16 9:25
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);
        String name = pros.getProperty("name");
        String passWord = pros.getProperty("passWord");
        System.out.println("name:" + name + ",password:" + passWord);
    }
}
