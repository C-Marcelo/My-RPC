import Service.HelloServiceImpl;
import com.myk.HelloService;
import com.myk.serializer.KryoSerializer;
import com.myk.transport.netty.server.NettyServer;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author myk
 */
public class NettyServerTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        NettyServer server = new NettyServer("127.0.0.1", 9999);
        server.setSerializer(new KryoSerializer());
        server.publishService(helloService, HelloService.class);
    }


}
