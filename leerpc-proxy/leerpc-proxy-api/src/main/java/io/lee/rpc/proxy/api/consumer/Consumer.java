package io.lee.rpc.proxy.api.consumer;

import io.lee.rpc.protocol.RpcProtocol;
import io.lee.rpc.protocol.request.RpcRequest;
import io.lee.rpc.proxy.api.future.RPCFuture;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Service consumer
 */
public interface Consumer {

    /**
     * Consumers send requests to providers
     */
    RPCFuture sendRequest(RpcProtocol<RpcRequest> protocol) throws Exception;
}
