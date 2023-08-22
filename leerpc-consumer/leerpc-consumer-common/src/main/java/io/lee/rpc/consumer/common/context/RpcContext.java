package io.lee.rpc.consumer.common.context;

import io.lee.rpc.proxy.api.future.RPCFuture;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Save context of RPC
 */
public class RpcContext {

    private RpcContext(){
    }

    /**
     * RpcContext singleton
     */
    private static final RpcContext AGENT = new RpcContext();

    /**
     * InheritableThreadLocal used to store RPCFuture
     */
    private static final InheritableThreadLocal<RPCFuture> RPC_FUTURE_INHERITABLE_THREAD_LOCAL = new InheritableThreadLocal<>();

    /**
     * Get RpcContext singleton
     */
    public static RpcContext getContext(){
        return AGENT;
    }

    /**
     * Save RPCFuture to InheritableThreadLocal
     */
    public void setRPCFuture(RPCFuture rpcFuture){
        RPC_FUTURE_INHERITABLE_THREAD_LOCAL.set(rpcFuture);
    }

    /**
     * Get RPCFuture
     */
    public RPCFuture getRPCFuture(){
        return RPC_FUTURE_INHERITABLE_THREAD_LOCAL.get();
    }

    /**
     * Remove RPCFuture
     */
    public void removeRPCFuture(){
        RPC_FUTURE_INHERITABLE_THREAD_LOCAL.remove();
    }
}
