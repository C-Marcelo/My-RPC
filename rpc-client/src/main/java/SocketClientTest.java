import com.myk.HelloObject;
import com.myk.HelloService;
import com.myk.serializer.KryoSerializer;
import com.myk.transport.RpcClientProxy;
import com.myk.transport.socket.client.SocketClient;

/**
 * 测试用消费者（客户端）
 *
 * @author myk
 */
public class SocketClientTest {

    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.setSerializer(new KryoSerializer());
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.Hello(object);
        System.out.println(res);
    }

}
