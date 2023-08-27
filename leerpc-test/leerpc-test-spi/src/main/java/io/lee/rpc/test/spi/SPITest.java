package io.lee.rpc.test.spi;

import io.lee.rpc.spi.loader.ExtensionLoader;
import io.lee.rpc.test.spi.service.SPIService;
import org.junit.Test;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description SPI test
 */
public class SPITest {
    @Test
    public void testSpiLoader(){
        SPIService spiService = ExtensionLoader.getExtension(SPIService.class, "spiService");
        String result = spiService.hello("lee");
        System.out.println(result);
    }
}
