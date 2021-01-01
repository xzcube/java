package netprogram;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**TCP网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地，并返回“发送成功”给客户端
 *
 * @author ：xzcube
 * @date ：Created in 2020/12/21 14:53
 */
public class TCPTest3 {
    @Test
    public void client(){
        InputStream is = null;
        Socket socket = null;
        OutputStream ops = null;
        InputStream isn = null;
        ByteArrayOutputStream baos = null;

        try {
            is = new FileInputStream("智乃.jpg");
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            ops = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                ops.write(buffer, 0, len);
            }

            socket.shutdownOutput();

            //客户端接收到服务器的消息，并输出到控制台
            isn = socket.getInputStream();
            baos = new ByteArrayOutputStream(20);
            byte[] bytes = new byte[10];
            int len2;
            while ((len2 = isn.read(bytes)) != -1){
                baos.write(bytes, 0, len2);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ops != null) {
                try {
                    ops.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isn != null) {
                try {
                    isn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream isp = null;
        OutputStream ops = null;
        OutputStream ost = null;
        try {
            ss = new ServerSocket(9999);
            socket = ss.accept();
            isp = socket.getInputStream();
            ops = new FileOutputStream("智乃与兔子.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while((len = isp.read(buffer)) != -1){
                ops.write(buffer);
            }

            //服务器返回给客户端一条信息
            ost = socket.getOutputStream();
            ost.write("你好，照片已经收到，非常可爱".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ops != null) {
                try {
                    ops.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isp != null) {
                try {
                    isp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ost != null) {
                try {
                    ost.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
