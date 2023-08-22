package io.lee.rpc.proxy.api.callback;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Async RPC Callback
 */
public interface AsyncRPCCallback {

    /**
     * Callback method on success
     */
    void onSuccess(Object result);

    /**
     * Callback method on exception
     */
    void onException(Exception e);
}
