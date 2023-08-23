package io.lee.rpc.provider;

import io.lee.rpc.provider.common.scanner.RpcServiceScanner;
import io.lee.rpc.provider.common.server.base.BaseServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Start RPC with Java native mode
 */
public class RpcSingleServer extends BaseServer {

    private final Logger logger = LoggerFactory.getLogger(RpcSingleServer.class);

    public RpcSingleServer(String serverAddress, String registryAddress, String registryType, String scanPackage, String reflectType) {
        // Call the parent class constructor
        super(serverAddress, registryAddress, registryType, reflectType);
        try {
            this.handlerMap = RpcServiceScanner.doScannerWithRpcServiceAnnotationFilterAndRegistryService(this.host, this.port, scanPackage, registryService);
        } catch (Exception e) {
            logger.error("RPC Server init error", e);
        }
    }
}
