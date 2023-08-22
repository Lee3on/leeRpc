package io.lee.rpc.proxy.api;


import io.lee.rpc.proxy.api.config.ProxyConfig;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Proxy factory interface
 */
public interface ProxyFactory {

    /**
     * Get proxy object
     */
    <T> T getProxy(Class<T> clazz);

    /**
     * Default initialization
     */
    default <T> void init(ProxyConfig<T> proxyConfig){}
}
