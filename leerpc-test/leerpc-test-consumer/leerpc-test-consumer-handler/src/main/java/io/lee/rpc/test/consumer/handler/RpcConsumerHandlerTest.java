package io.lee.rpc.test.consumer.handler;

import io.lee.rpc.consumer.common.RpcConsumer;
import io.lee.rpc.consumer.common.callback.AsyncRPCCallback;
import io.lee.rpc.consumer.common.context.RpcContext;
import io.lee.rpc.consumer.common.future.RPCFuture;
import io.lee.rpc.protocol.RpcProtocol;
import io.lee.rpc.protocol.header.RpcHeaderFactory;
import io.lee.rpc.protocol.request.RpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Test consumer handler
 */
public class RpcConsumerHandlerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcConsumerHandlerTest.class);

    public static void main(String[] args) throws Exception {
        RpcConsumer consumer = RpcConsumer.getInstance();
        RPCFuture rpcFuture = consumer.sendRequest(getRpcRequestProtocol());
        rpcFuture.addCallback(new AsyncRPCCallback() {
            @Override
            public void onSuccess(Object result) {
                LOGGER.info("从服务消费者获取到的数据===>>>" + result);
            }

            @Override
            public void onException(Exception e) {
                LOGGER.info("抛出了异常===>>>" + e);
            }
        });
        Thread.sleep(200);
        consumer.close();
    }

    public static void mainOneway(String[] args) throws Exception {
        RpcConsumer consumer = RpcConsumer.getInstance();
        consumer.sendRequest(getRpcRequestProtocolOneway());
        LOGGER.info("无需获取返回的结果数据");
        consumer.close();
    }

    public static void mainAsync(String[] args) throws Exception {
        RpcConsumer consumer = RpcConsumer.getInstance();
        consumer.sendRequest(getRpcRequestProtocolAsync());
        RPCFuture future = RpcContext.getContext().getRPCFuture();
        LOGGER.info("从服务消费者获取到的数据===>>>" + future.get());
        consumer.close();
    }

    public static void mainSync(String[] args) throws Exception {
        RpcConsumer consumer = RpcConsumer.getInstance();
        RPCFuture future = consumer.sendRequest(getRpcRequestProtocolSync());
        LOGGER.info("从服务消费者获取到的数据===>>>" + future.get());
        consumer.close();
    }

    private static RpcProtocol<RpcRequest> getRpcRequestProtocol(){
        // Test sending request
        RpcProtocol<RpcRequest> protocol = new RpcProtocol<RpcRequest>();
        protocol.setHeader(RpcHeaderFactory.getRequestHeader("jdk"));
        RpcRequest request = new RpcRequest();
        request.setClassName("io.lee.rpc.test.api.DemoService");
        request.setGroup("lee");
        request.setMethodName("hello");
        request.setParameters(new Object[]{"lee"});
        request.setParameterTypes(new Class[]{String.class});
        request.setVersion("1.0.0");
        request.setAsync(false);
        request.setOneway(false);
        protocol.setBody(request);
        return protocol;
    }

    private static RpcProtocol<RpcRequest> getRpcRequestProtocolOneway(){
        // Test sending request oneway
        RpcProtocol<RpcRequest> protocol = new RpcProtocol<RpcRequest>();
        protocol.setHeader(RpcHeaderFactory.getRequestHeader("jdk"));
        RpcRequest request = new RpcRequest();
        request.setClassName("io.lee.rpc.test.api.DemoService");
        request.setGroup("lee");
        request.setMethodName("hello");
        request.setParameters(new Object[]{"lee"});
        request.setParameterTypes(new Class[]{String.class});
        request.setVersion("1.0.0");
        request.setAsync(false);
        request.setOneway(true);
        protocol.setBody(request);
        return protocol;
    }

    private static RpcProtocol<RpcRequest> getRpcRequestProtocolAsync(){
        // Test sending request async
        RpcProtocol<RpcRequest> protocol = new RpcProtocol<RpcRequest>();
        protocol.setHeader(RpcHeaderFactory.getRequestHeader("jdk"));
        RpcRequest request = new RpcRequest();
        request.setClassName("io.lee.rpc.test.api.DemoService");
        request.setGroup("lee");
        request.setMethodName("hello");
        request.setParameters(new Object[]{"lee"});
        request.setParameterTypes(new Class[]{String.class});
        request.setVersion("1.0.0");
        request.setAsync(true);
        request.setOneway(false);
        protocol.setBody(request);
        return protocol;
    }

    private static RpcProtocol<RpcRequest> getRpcRequestProtocolSync(){
        // Test sending request sync
        RpcProtocol<RpcRequest> protocol = new RpcProtocol<RpcRequest>();
        protocol.setHeader(RpcHeaderFactory.getRequestHeader("jdk"));
        RpcRequest request = new RpcRequest();
        request.setClassName("io.lee.rpc.test.api.DemoService");
        request.setGroup("lee");
        request.setMethodName("hello");
        request.setParameters(new Object[]{"lee"});
        request.setParameterTypes(new Class[]{String.class});
        request.setVersion("1.0.0");
        request.setAsync(false);
        request.setOneway(false);
        protocol.setBody(request);
        return protocol;
    }
}
