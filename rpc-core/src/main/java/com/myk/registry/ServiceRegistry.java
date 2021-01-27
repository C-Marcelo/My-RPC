package com.myk.registry;

import java.net.InetSocketAddress;

/**
 * @author myk
 */
public interface ServiceRegistry {
    void register(String serviceName, InetSocketAddress inetSocketAddress);

    InetSocketAddress lookupService(String serviceName);
}
