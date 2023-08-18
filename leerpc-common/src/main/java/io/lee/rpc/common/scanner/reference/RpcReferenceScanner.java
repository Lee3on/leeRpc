package io.lee.rpc.common.scanner.reference;

import io.lee.rpc.annotation.RpcReference;
import io.lee.rpc.common.scanner.ClassScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Scanner of @RpcReference annotation
 */
public class RpcReferenceScanner extends ClassScanner {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcReferenceScanner.class);


    /**
     * Scan the classes under the specified package and filter the classes marked with @RpcService annotation
     */
    public static Map<String, Object> doScannerWithRpcReferenceAnnotationFilter(/*String host, int port, */ String scanPackage/*, RegistryService*/) throws Exception{
        Map<String, Object> handlerMap = new HashMap<>();
        List<String> classNameList = getClassNameList(scanPackage, true);
        if (classNameList == null || classNameList.isEmpty()){
            return handlerMap;
        }
        classNameList.stream().forEach((className) -> {
            try {
                Class<?> clazz = Class.forName(className);
                Field[] declaredFields = clazz.getDeclaredFields();
                Stream.of(declaredFields).forEach((field) -> {
                    RpcReference rpcReference = field.getAnnotation(RpcReference.class);
                    if (rpcReference != null){
                        // TODO Process subsequent logic,
                        //  put the interface reference proxy object marked by @RpcReference annotation into the global cache
                        LOGGER.info("当前标注了@RpcReference注解的字段名称===>>> " + field.getName());
                        LOGGER.info("@RpcReference注解上标注的属性信息如下：");
                        LOGGER.info("version===>>> " + rpcReference.version());
                        LOGGER.info("group===>>> " + rpcReference.group());
                        LOGGER.info("registryType===>>> " + rpcReference.registryType());
                        LOGGER.info("registryAddress===>>> " + rpcReference.registryAddress());
                    }
                });
            } catch (Exception e) {
                LOGGER.error("scan classes throws exception: {}", e);
            }
        });
        return handlerMap;
    }
}
