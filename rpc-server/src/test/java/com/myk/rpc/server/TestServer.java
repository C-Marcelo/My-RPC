package com.myk.rpc.server;

import com.myk.rpc.api.HelloService;

/**
 * @author myk
 */
public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
    }
}
