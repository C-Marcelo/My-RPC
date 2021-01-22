package com.myk;

import com.myk.rpc.api.HelloObject;
import com.myk.rpc.api.HelloService;
import com.myk.rpc.client.RpcClientProxy;

/**
 * @author myk
 */
public class TestClient {
    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9000);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.Hello(object);
        System.out.println(res);
    }
}
