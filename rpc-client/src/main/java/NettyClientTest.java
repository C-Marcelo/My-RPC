import com.myk.HelloObject;
import com.myk.HelloService;
import com.myk.loadbalancer.RoundRobinLoadBalancer;
import com.myk.serializer.KryoSerializer;
import com.myk.transport.RpcClient;
import com.myk.transport.RpcClientProxy;
import com.myk.transport.netty.client.NettyClient;

/**
 * 测试用Netty消费者
 *
 * @author myk
 */
public class NettyClientTest {

    public static void main(String[] args) {
        RpcClient client = new NettyClient(new RoundRobinLoadBalancer());
        client.setSerializer(new KryoSerializer());
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        for(int i = 0; i<20; i++){
            HelloObject object = new HelloObject(i, "This is a message");
            System.out.println(helloService.Hello(object));
        }
    }

}
