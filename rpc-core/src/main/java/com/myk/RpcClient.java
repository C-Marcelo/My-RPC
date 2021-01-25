package com.myk;

import entity.RpcRequest;

/**
 * @author myk
 */
public interface RpcClient {
    Object sendRequest(RpcRequest rpcRequest);
}
