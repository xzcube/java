package objectflow;

import org.junit.Test;

import java.io.*;

/**对象流的使用：
 * ObjectInputStream  ObjectOutputStream
 * 作用：用于储存和读取基本数据类型数据或对象的处理流，它的强大之处在于能够把java中的对象写入到数据源中，也能把对象从数据源中还原回来
 *如果需要让某个对象支持序列化机制，则必须让对象所属的类及其属性是可序列化的
 * 实现接口:Serializable
 *         Externalizable
 *当前类提供一个全局常量 serialVersionUID
 * 除了当前类需要实现serializable接口以外，需要保证其内部所有属性都是可序列化的（默认情况下，基本数据类型都是可序列化的）
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/19 15:57
 */
public class ObjectInputOutputStream {
    /*
    序列化过程：将内存中的对象保存到磁盘中或通过网络传输出去
    ObjectputStream实现
     */
    @Test
    public void testOutPutStream(){
        ObjectOutputStream oos = null;
        try {
            //生成文件与搭建节点流
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //写入操作
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();  //刷新操作

            oos.writeObject(new Person("整整", 20));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null)
                try {
                    //资源关闭
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /*
    反序列化：将磁盘文件中的对象还原为内存中的java对象
    ObjectInputStream类实现
     */
    @Test
    public void testObjectStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;
            Object o = ois.readObject();
            Person p = (Person) o;
            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
