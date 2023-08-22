package io.lee.rpc.proxy.jdk;

import io.lee.rpc.proxy.api.BaseProxyFactory;
import io.lee.rpc.proxy.api.ProxyFactory;

import java.lang.reflect.Proxy;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description JDK dynamic proxy factory
 */
public class JdkProxyFactory<T> extends BaseProxyFactory<T> implements ProxyFactory {
    @Override
    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class<?>[]{clazz},
                objectProxy
        );
    }
}