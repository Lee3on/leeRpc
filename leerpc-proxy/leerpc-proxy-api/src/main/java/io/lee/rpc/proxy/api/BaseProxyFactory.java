package io.lee.rpc.proxy.api;

import io.lee.rpc.proxy.api.object.ObjectProxy;
import io.lee.rpc.proxy.api.config.ProxyConfig;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Base proxy factory
 */
public abstract class BaseProxyFactory<T> implements ProxyFactory {

    protected ObjectProxy<T> objectProxy;

    @Override
    public <T> void init(ProxyConfig<T> proxyConfig) {
        this.objectProxy = new ObjectProxy(proxyConfig.getClazz(),
                proxyConfig.getServiceVersion(),
                proxyConfig.getServiceGroup(),
                proxyConfig.getSerializationType(),
                proxyConfig.getTimeout(),
                proxyConfig.getConsumer(),
                proxyConfig.getAsync(),
                proxyConfig.getOneway());
    }
}
