import com.myk.HelloObject;
import com.myk.HelloService;
import com.myk.RpcClientProxy;
import com.myk.socket.client.SocketClient;

/**
 * @author myk
 */
public class SocketClientTest {
    public static void main(String[] args) {
        SocketClient socketClient = new SocketClient("127.0.0.1",8086);
        RpcClientProxy proxy = new RpcClientProxy(socketClient);
        HelloService service = proxy.getProxy(HelloService.class);
        String message = service.Hello(new HelloObject(1, "This is a message"));
        System.out.println(message);
    }
}
