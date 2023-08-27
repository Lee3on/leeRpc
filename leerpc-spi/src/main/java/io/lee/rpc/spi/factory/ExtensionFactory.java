package io.lee.rpc.spi.factory;

import io.lee.rpc.spi.annotation.SPI;

/**
 *  ExtensionFactory
 */
@SPI("spi")
public interface ExtensionFactory {

    /**
     * Get extension class instance
     * @param <T>  Generic type
     * @param key  SPI key
     * @param clazz Class type of extension
     * @return Extension class instance
     */
    <T> T getExtension(String key, Class<T> clazz);
}
