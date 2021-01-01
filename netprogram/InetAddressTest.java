package netprogram;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/20 15:39
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet1);
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress());
            System.out.println(localHost.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
