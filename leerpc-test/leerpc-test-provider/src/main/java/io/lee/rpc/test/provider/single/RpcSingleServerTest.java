package io.lee.rpc.test.provider.single;

import io.lee.rpc.provider.RpcSingleServer;
import org.junit.Test;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Test starting RPC service with Java native mode
 */
public class RpcSingleServerTest {

    @Test
    public void startRpcSingleServer(){
        RpcSingleServer singleServer = new RpcSingleServer("127.0.0.1:27880", "io.lee.rpc.test", "cglib");
        singleServer.startNettyServer();
    }
}
