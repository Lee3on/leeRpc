package io.lee.rpc.consumer;

import io.lee.rpc.consumer.common.RpcConsumer;
import io.lee.rpc.proxy.api.ProxyFactory;
import io.lee.rpc.proxy.api.async.IAsyncObjectProxy;
import io.lee.rpc.proxy.api.config.ProxyConfig;
import io.lee.rpc.proxy.api.object.ObjectProxy;
import io.lee.rpc.proxy.jdk.JdkProxyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Service consumer client
 */
public class RpcClient {

    private final Logger logger = LoggerFactory.getLogger(RpcClient.class);
    private String serviceVersion;
    private String serviceGroup;
    private String serializationType;
    private long timeout;
    private boolean async;
    private boolean oneway;

    public RpcClient(String serviceVersion, String serviceGroup, String serializationType, long timeout, boolean async, boolean oneway) {
        this.serviceVersion = serviceVersion;
        this.timeout = timeout;
        this.serviceGroup = serviceGroup;
        this.serializationType = serializationType;
        this.async = async;
        this.oneway = oneway;
    }

    public <T> T create(Class<T> interfaceClass) {
        ProxyFactory proxyFactory = new JdkProxyFactory<T>();
        proxyFactory.init(new ProxyConfig(interfaceClass, serviceVersion, serviceGroup, serializationType, timeout, RpcConsumer.getInstance(), async, oneway));
        return proxyFactory.getProxy(interfaceClass);
    }

    public <T> IAsyncObjectProxy createAsync(Class<T> interfaceClass) {
        return new ObjectProxy<T>(interfaceClass, serviceVersion, serviceGroup, serializationType, timeout, RpcConsumer.getInstance(), async, oneway);
    }

    public void shutdown() {
        RpcConsumer.getInstance().close();
    }
}
