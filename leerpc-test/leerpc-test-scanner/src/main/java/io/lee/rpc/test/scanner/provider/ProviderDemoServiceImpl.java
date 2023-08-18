package io.lee.rpc.test.scanner.provider;

import io.lee.rpc.annotation.RpcService;
import io.lee.rpc.test.scanner.service.DemoService;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description DemoService implementation class
 */
@RpcService(interfaceClass = DemoService.class, interfaceClassName = "io.lee.rpc.test.scanner.service.DemoService", version = "1.0.0", group = "lee")
public class ProviderDemoServiceImpl implements DemoService {

}
