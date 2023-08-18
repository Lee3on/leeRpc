package io.lee.rpc.serialization.api;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Serialization interface
 */
public interface Serialization {

    <T> byte[] serialize(T obj);

    <T> T deserialize(byte[] data, Class<T> cls);
}
