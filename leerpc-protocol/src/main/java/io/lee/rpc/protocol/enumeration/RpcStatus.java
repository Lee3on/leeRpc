package io.lee.rpc.protocol.enumeration;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description RPC service status
 */
public enum RpcStatus {

    SUCCESS(0),
    FAIL(1);

    private final int code;

    RpcStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
