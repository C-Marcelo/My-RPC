package com.myk.provider;

import java.net.InetSocketAddress;

/**
 * @author myk
 */
public interface ServiceProvider {

     <T> void addServiceProvider(T service);

     Object getServiceProvider(String serviceName);

}
