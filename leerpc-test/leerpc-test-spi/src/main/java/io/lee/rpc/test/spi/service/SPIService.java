package io.lee.rpc.test.spi.service;

import io.lee.rpc.spi.annotation.SPI;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description io.lee.rpc.test.spi.service.SPIService
 */
@SPI("spiService")
public interface SPIService {
    String hello(String name);
}