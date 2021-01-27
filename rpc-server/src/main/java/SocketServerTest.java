import Service.HelloServiceImpl;
import com.myk.HelloService;
import com.myk.serializer.KryoSerializer;
import com.myk.transport.socket.server.SocketServer;

/**
 * @author myk
 */
public class SocketServerTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        SocketServer socketServer = new SocketServer("127.0.0.1", 9998);
        socketServer.setSerializer(new KryoSerializer());
        socketServer.publishService(helloService, HelloService.class);
    }
}
