package io.lee.rpc.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RPC reference annotation, marked on the service reference field
 * @author Shuaijie
 * @version 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Autowired
public @interface RpcReference {

    /**
    * Reference version
    */
    String version() default "1.0.0";

    /**
     * Registry type, default is zookeeper,
     * it can be zookeeper, nacos, etcd, consul
     */
    String registryType() default "zookeeper";

    /**
     * Registry address, default is localhost:2181
     */
    String registryAddress() default "127.0.0.1:2181";

    /**
     * Load balance type, default is zkconsistenthash,
     * it can be random, roundrobin, leastactive.
     */
    String loadBalanceType() default "zkconsistenthash";

    /**
     * Serializer type, default is protostuff,
     * it can be protostuff, hessian, kryo.
     */
    String serializerType() default "protostuff";

    /**
     * Timeout for request, default is 5000ms
     */
    long timeout() default 5000;

    /**
     * Whether to enable async, default is false
     */
    boolean async() default false;

    /**
     * Whether to enable oneway, default is false
     */
    boolean oneway() default false;

    /**
     * Proxy type, default is jdk,
     * it can be jdk, javassist, cglib.
     */
    String proxy() default "jdk";

    /**
    * service group
    */
    String group() default "";
}
