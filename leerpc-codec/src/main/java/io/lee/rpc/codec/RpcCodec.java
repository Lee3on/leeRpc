package io.lee.rpc.codec;

import io.lee.rpc.serialization.api.Serialization;
import io.lee.rpc.spi.loader.ExtensionLoader;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Interface of encoding and decoding implementation, providing default methods for serialization and deserialization
 */
public interface RpcCodec {

    /**
     * Get the serialization handle through SPI according to serializationType
     * @param serializationType Serialization type
     * @return Serialization object
     */
    default Serialization getSerialization(String serializationType){
        return ExtensionLoader.getExtension(Serialization.class, serializationType);
    }
}
