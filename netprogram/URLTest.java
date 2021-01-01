package netprogram;

import java.net.MalformedURLException;
import java.net.URL;

/**URL网络编程
 * URL：统一资源定位符，对应着互联网上的某一资源地址
 * 2.格式：http://localhost:8080/examps/beayty.jpg?username=Tom
 *        协议    主机名           资源地址             参数列表
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/21 17:09
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examps/beayty.jpg?username=Tom");
            System.out.println(url.getProtocol()); //获取该URL的协议名
            System.out.println(url.getHost()); //获取该URL的主机名
            System.out.println(url.getPort()); //获取该URL的端口号
            System.out.println(url.getPath()); //获取该URL的文件路径
            System.out.println(url.getFile()); //获取该URL的文件名
            System.out.println(url.getQuery()); //获取该URL的查询名
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
