package io.lee.rpc.protocol;

import io.lee.rpc.protocol.header.RpcHeader;

import java.io.Serializable;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Rpc protocol
 */
public class RpcProtocol<T> implements Serializable {
    private static final long serialVersionUID = 292789485166173277L;

    /**
     * Message header
     */
    private RpcHeader header;
    /**
     * Message body
     */
    private T body;

    public RpcHeader getHeader() {
        return header;
    }

    public void setHeader(RpcHeader header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
