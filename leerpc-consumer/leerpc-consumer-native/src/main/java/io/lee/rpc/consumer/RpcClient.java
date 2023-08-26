package io.lee.rpc.consumer;

import io.lee.rpc.common.exception.RegistryException;
import io.lee.rpc.consumer.common.RpcConsumer;
import io.lee.rpc.proxy.api.ProxyFactory;
import io.lee.rpc.proxy.api.async.IAsyncObjectProxy;
import io.lee.rpc.proxy.api.config.ProxyConfig;
import io.lee.rpc.proxy.api.object.ObjectProxy;
import io.lee.rpc.proxy.jdk.JdkProxyFactory;
import io.lee.rpc.registry.api.RegistryService;
import io.lee.rpc.registry.api.config.RegistryConfig;
import io.lee.rpc.registry.zookeeper.ZookeeperRegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Service consumer client
 */
public class RpcClient {

    private final Logger logger = LoggerFactory.getLogger(RpcClient.class);
    RegistryService registryService;
    private String serviceVersion;
    private String serviceGroup;
    private String serializationType;
    private long timeout;
    private boolean async;
    private boolean oneway;

    public RpcClient(String registryAddress, String registryType, String serviceVersion, String serviceGroup, String serializationType, long timeout, boolean async, boolean oneway) {
        this.serviceVersion = serviceVersion;
        this.timeout = timeout;
        this.serviceGroup = serviceGroup;
        this.serializationType = serializationType;
        this.async = async;
        this.oneway = oneway;
        this.registryService = this.getRegistryService(registryAddress, registryType);
    }

    private RegistryService getRegistryService(String registryAddress, String registryType) {
        if (StringUtils.isEmpty(registryType)){
            throw new IllegalArgumentException("registry type is null");
        }
        //TODO 后续SPI扩展
        RegistryService registryService = new ZookeeperRegistryService();
        try {
            registryService.init(new RegistryConfig(registryAddress, registryType));
        } catch (Exception e) {
            logger.error("RpcClient init registry service throws exception:{}", e);
            throw new RegistryException(e.getMessage(), e);
        }
        return registryService;
    }

    public <T> T create(Class<T> interfaceClass) {
        ProxyFactory proxyFactory = new JdkProxyFactory<T>();
        proxyFactory.init(new ProxyConfig(interfaceClass, serviceVersion, serviceGroup, serializationType, timeout, registryService, RpcConsumer.getInstance(), async, oneway));
        return proxyFactory.getProxy(interfaceClass);
    }

    public <T> IAsyncObjectProxy createAsync(Class<T> interfaceClass) {
        return new ObjectProxy<T>(interfaceClass, serviceVersion, serviceGroup, serializationType, timeout, registryService, RpcConsumer.getInstance(), async, oneway);
    }

    public void shutdown() {
        RpcConsumer.getInstance().close();
    }
}
