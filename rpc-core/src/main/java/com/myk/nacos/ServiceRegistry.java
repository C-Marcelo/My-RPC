package com.myk.nacos;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.pojo.Instance;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @author myk
 */
public interface ServiceRegistry {
    void register(String serviceName, InetSocketAddress inetSocketAddress);

    InetSocketAddress lookupService(String serviceName);

    List<Instance> getAllInstances(String serviceName) throws NacosException;
}
