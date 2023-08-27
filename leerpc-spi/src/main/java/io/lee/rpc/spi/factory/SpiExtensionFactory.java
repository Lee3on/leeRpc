package io.lee.rpc.spi.factory;

import io.lee.rpc.spi.annotation.SPI;
import io.lee.rpc.spi.annotation.SPIClass;
import io.lee.rpc.spi.loader.ExtensionLoader;

import java.util.Optional;

/**
 * SpiExtensionFactory
 */
@SPIClass
public class SpiExtensionFactory implements ExtensionFactory {
    @Override
    public <T> T getExtension(final String key, final Class<T> clazz) {
        return Optional.ofNullable(clazz)
                .filter(Class::isInterface)
                .filter(cls -> cls.isAnnotationPresent(SPI.class))
                .map(ExtensionLoader::getExtensionLoader)
                .map(ExtensionLoader::getDefaultSpiClassInstance)
                .orElse(null);
    }
}
