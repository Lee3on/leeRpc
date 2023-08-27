package io.lee.rpc.test.scanner.consumer.service.impl;

import io.lee.rpc.annotation.RpcReference;
import io.lee.rpc.test.scanner.consumer.service.ConsumerBusinessService;
import io.lee.rpc.test.scanner.service.DemoService;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Service consumer business logic implementation class
 */
public class ConsumerBusinessServiceImpl implements ConsumerBusinessService {

    @RpcReference(registryType = "zookeeper", registryAddress = "127.0.0.1:2181", version = "1.0.0", group = "lee")
    private DemoService demoService;

}
