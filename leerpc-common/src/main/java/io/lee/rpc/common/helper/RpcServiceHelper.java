package io.lee.rpc.common.helper;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description RPC service helper class
 */
public class RpcServiceHelper {

    /**
     * Join strings to build the service key
     * @param serviceName service name
     * @param serviceVersion service version
     * @param group service group
     * @return serviceName#serviceVersion#ServiceGroup
     */
    public static String buildServiceKey(String serviceName, String serviceVersion, String group) {
        return String.join("#", serviceName, serviceVersion, group);
    }
}
