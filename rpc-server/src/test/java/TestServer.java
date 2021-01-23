import client.registry.DefaultServiceRegistry;
import server.RpcServer;

/**
 * @author myk
 */
public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        DefaultServiceRegistry defaultServiceRegistry = new DefaultServiceRegistry();
        defaultServiceRegistry.register(helloService);
        RpcServer rpcServer = new RpcServer(defaultServiceRegistry);
        rpcServer.start(9000);
    }
}
