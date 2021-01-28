package com.myk.loadbalancer;

import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

/**
 * @author myk
 */
public class RoundRobinLoadBalancer implements LoadBalancer{
    private static int index = 0;
    @Override
    public Instance select(List<Instance> instances) {
        if(index >= instances.size()){
            index %= instances.size();
        }
        return instances.get(index++);
    }
}
