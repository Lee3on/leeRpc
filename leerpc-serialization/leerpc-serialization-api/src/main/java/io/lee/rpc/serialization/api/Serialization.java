package io.lee.rpc.serialization.api;

import io.lee.rpc.constants.RpcConstants;
import io.lee.rpc.spi.annotation.SPI;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Serialization interface
 */
@SPI(RpcConstants.SERIALIZATION_JDK)
public interface Serialization {

    <T> byte[] serialize(T obj);

    <T> T deserialize(byte[] data, Class<T> cls);
}
