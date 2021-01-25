import com.myk.HelloObject;
import com.myk.HelloService;
import com.myk.RpcClientProxy;
import com.myk.netty.client.NettyClient;

/**
 * @author myk
 */
public class NettyClientTest {
    public static void main(String[] args) {
        NettyClient nettyClient = new NettyClient("127.0.0.1",8086);
        RpcClientProxy proxy = new RpcClientProxy(nettyClient);
        HelloService service = proxy.getProxy(HelloService.class);
        HelloObject helloObject = new HelloObject(2, "this is a netty message");
        String msg = service.Hello(helloObject);
        System.out.println(msg);
    }
}
