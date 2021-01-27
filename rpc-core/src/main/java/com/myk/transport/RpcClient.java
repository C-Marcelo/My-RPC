package com.myk.transport;

import com.myk.serializer.CommonSerializer;
import entity.RpcRequest;

/**
 * @author myk
 */
public interface RpcClient {
    Object sendRequest(RpcRequest rpcRequest);
    void setSerializer(CommonSerializer serializer);
}
