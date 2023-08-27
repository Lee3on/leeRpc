package io.lee.rpc.test.spi.service.impl;

import io.lee.rpc.spi.annotation.SPIClass;
import io.lee.rpc.test.spi.service.SPIService;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description SPI service implementation
 */
@SPIClass
public class SPIServiceImpl implements SPIService {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}