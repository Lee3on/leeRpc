package io.lee.rpc.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RPC service annotation, marked on the service implementation class
 * @author Shuaijie
 * @version 1.0.0
 */
@Target({ElementType.TYPE}) // 使得注解只能被用在类上
@Retention(RetentionPolicy.RUNTIME) // 使得注解可以在运行时被反射机制读取到
@Component // 使得被注解的类可以被 Spring 扫描到
public @interface RpcService {

    /**
     * interface class
     */
    Class<?> interfaceClass() default void.class;

    /**
     * interface class name
     */
    String interfaceClassName() default "";

    /**
     * service version
     */
    String version() default "1.0.0";

    /**
     * service group
     */
    String group() default "";
}
