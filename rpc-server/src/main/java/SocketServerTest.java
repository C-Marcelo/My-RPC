import Service.HelloServiceImpl;
import com.myk.registry.DefaultServiceRegistry;
import com.myk.socket.server.SocketServer;

/**
 * @author myk
 */
public class SocketServerTest {
    public static void main(String[] args) {
        DefaultServiceRegistry registry = new DefaultServiceRegistry();
        HelloServiceImpl service = new HelloServiceImpl();
        registry.register(service);
        SocketServer server = new SocketServer(registry);
        server.start(8086);

    }
}
