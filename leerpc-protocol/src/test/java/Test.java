import io.lee.rpc.protocol.RpcProtocol;
import io.lee.rpc.protocol.header.RpcHeader;
import io.lee.rpc.protocol.header.RpcHeaderFactory;
import io.lee.rpc.protocol.request.RpcRequest;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description
 */
public class Test {
    public static RpcProtocol<RpcRequest> getRpcProtocol(){
        RpcHeader header = RpcHeaderFactory.getRequestHeader("jdk");
        RpcRequest body = new RpcRequest();
        body.setOneway(false);
        body.setAsync(false);
        body.setClassName("io.lee.rpc.demo.RpcProtocol");
        body.setMethodName("hello");
        body.setGroup("lee");
        body.setParameters(new Object[]{"lee"});
        body.setParameterTypes(new Class[]{String.class});
        body.setVersion("1.0.0");
        RpcProtocol<RpcRequest> protocol = new RpcProtocol<>();
        protocol.setBody(body);
        protocol.setHeader(header);
        return protocol;
    }
}
