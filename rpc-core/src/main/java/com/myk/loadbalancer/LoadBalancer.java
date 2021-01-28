package com.myk.loadbalancer;

import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

/**
 * @author myk
 */
public interface LoadBalancer {
    Instance select(List<Instance> instances);

}
