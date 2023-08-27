package io.lee.rpc.spi.annotation;

import java.lang.annotation.*;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description @SPI
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SPI {

    /**
     * Default extension name
     */
    String value() default "";
}
