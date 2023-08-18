package io.lee.rpc.protocol.base;

import java.io.Serializable;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Message body base class
 */
public class RpcMessage implements Serializable {

    /**
     * Whether it is oneway
     */
    private boolean oneway;

    /**
     * Whether it is async
     */
    private boolean async;

    public boolean getOneway() {
        return oneway;
    }

    public void setOneway(boolean oneway) {
        this.oneway = oneway;
    }

    public boolean getAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }
}
