package io.lee.rpc.proxy.api.async;

import io.lee.rpc.proxy.api.future.RPCFuture;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Asynchronous proxy interface
 */
public interface IAsyncObjectProxy {

    /**
     * Async proxy object calls method
     * @param funcName function name
     * @param args function parameters
     * @return RPCFuture object
     */
    RPCFuture call(String funcName, Object... args);
}
