package com.myk.transport;

import com.myk.serializer.CommonSerializer;

/**
 * @author myk
 */
public interface RpcServer {
    void start();

    void setSerializer(CommonSerializer serializer);

    <T> void publishService(Object service, Class<T> serviceClass);

}
