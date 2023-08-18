package io.lee.rpc.test.provider.service.impl;

import io.lee.rpc.annotation.RpcService;
import io.lee.rpc.test.api.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Implementation class of DemoService
 */
@RpcService(interfaceClass = DemoService.class, interfaceClassName = "io.lee.rpc.test.api.DemoService", version = "1.0.0", group = "lee")
public class ProviderDemoServiceImpl implements DemoService {
    private final Logger logger = LoggerFactory.getLogger(ProviderDemoServiceImpl.class);
    @Override
    public String hello(String name) {
        logger.info("调用hello方法传入的参数为===>>>{}", name);
        return "hello " + name;
    }
}