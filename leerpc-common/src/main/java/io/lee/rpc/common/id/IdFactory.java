package io.lee.rpc.common.id;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Simple ID factory class
 */
public class IdFactory {

    private final static AtomicLong REQUEST_ID_GEN = new AtomicLong(0);

    public static Long getId(){
        return REQUEST_ID_GEN.incrementAndGet();
    }
}
