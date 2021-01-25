import Service.HelloServiceImpl;
import com.myk.HelloService;
import com.myk.netty.server.NettyServer;
import com.myk.registry.DefaultServiceRegistry;

/**
 * @author myk
 */
public class NettyServerTest {
    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer();
        HelloService service = new HelloServiceImpl();
        DefaultServiceRegistry registry = new DefaultServiceRegistry();
        registry.register(service);
        nettyServer.start(8086);
    }
}
