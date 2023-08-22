package io.lee.rpc.test.consumer;

import io.lee.rpc.consumer.RpcClient;
import io.lee.rpc.proxy.api.async.IAsyncObjectProxy;
import io.lee.rpc.proxy.api.future.RPCFuture;
import io.lee.rpc.test.api.DemoService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Test RPC consumer using Java native
 */
public class RpcConsumerNativeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcConsumerNativeTest.class);

    public static void main(String[] args){
        RpcClient rpcClient = new RpcClient("1.0.0", "lee", "jdk", 3000, false, false);
        DemoService demoService = rpcClient.create(DemoService.class);
        String result = demoService.hello("lee");
        LOGGER.info("返回的结果数据===>>> " + result);
        rpcClient.shutdown();
    }

    @Test
    public void testInterfaceRpc(){
        RpcClient rpcClient = new RpcClient("1.0.0", "lee", "jdk", 3000, false, false);
        DemoService demoService = rpcClient.create(DemoService.class);
        String result = demoService.hello("lee");
        LOGGER.info("返回的结果数据===>>> " + result);
        rpcClient.shutdown();
    }

    @Test
    public void testAsyncInterfaceRpc() throws Exception {
        RpcClient rpcClient = new RpcClient("1.0.0", "lee", "jdk", 3000, false, false);
        IAsyncObjectProxy demoService = rpcClient.createAsync(DemoService.class);
        RPCFuture future = demoService.call("hello", "lee");
        LOGGER.info("返回的结果数据===>>> " + future.get());
        rpcClient.shutdown();
    }

}
