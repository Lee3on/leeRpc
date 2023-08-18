package io.lee.rpc.protocol.enumeration;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Protocol type
 */
public enum RpcType {
    // Request message
    REQUEST(1),
    // Response message
    RESPONSE(2),
    // Heartbeat data
    HEARTBEAT(3);

    private final int type;

    RpcType(int type) {
        this.type = type;
    }

    public static RpcType findByType(int type) {
        for (RpcType rpcType : RpcType.values()) {
            if (rpcType.getType() == type) {
                return rpcType;
            }
        }
        return null;
    }

    public int getType() {
        return type;
    }
}
