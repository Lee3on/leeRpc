package io.lee.rpc.provider.common.server.api;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description API of starting RPC service
 */
public interface Server {

    /**
     * Start Netty server
     */
    void startNettyServer();
}
