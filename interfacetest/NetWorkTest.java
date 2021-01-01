package interfacetest;

public class NetWorkTest {
    public static void main(String[] args) {
        ProxyServer proxyServer = new ProxyServer(new Server());
        proxyServer.browse();
    }
}


interface NetWork{
    void browse();
}


//被代理类
class Server implements NetWork{
    private int id;

    @Override
    public void browse() {
        System.out.println("真实服务器联网");
    }
}


//代理类
class ProxyServer implements NetWork{
    private NetWork netWork;

    public ProxyServer(NetWork netWork){
        this.netWork = netWork;
    }

    public void check(){
        System.out.println("联网之前的检查工作");
    }

    @Override
    public void browse() {
        this.check();
        this.netWork.browse();
    }
}
