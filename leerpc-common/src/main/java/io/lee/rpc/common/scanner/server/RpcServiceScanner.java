package io.lee.rpc.common.scanner.server;

import io.lee.rpc.annotation.RpcService;
import io.lee.rpc.common.helper.RpcServiceHelper;
import io.lee.rpc.common.scanner.ClassScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Scanner of @RpcService annotation
 */
public class RpcServiceScanner extends ClassScanner {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcServiceScanner.class);

    /**
     * Scan the classes under the specified package and filter the classes marked with @RpcService annotation
     */
    public static Map<String, Object> doScannerWithRpcServiceAnnotationFilterAndRegistryService(String scanPackage) throws Exception{
        Map<String, Object> handlerMap = new HashMap<>();
        List<String> classNameList = getClassNameList(scanPackage, true);
        if (classNameList == null || classNameList.isEmpty()){
            return handlerMap;
        }
        classNameList.stream().forEach((className) -> {
            try {
                Class<?> clazz = Class.forName(className);
                RpcService rpcService = clazz.getAnnotation(RpcService.class);
                if (rpcService != null){
                    // Use interfaceClass first, if the name of interfaceClass is empty, use interfaceClassName
                    // TODO 后续逻辑向注册中心注册服务元数据，同时向handlerMap中记录标注了RpcService注解的类实例
                    // key in the handlerMap is stored as serviceName+version+group, and is processed according to the actual situation
                    String serviceName = getServiceName(rpcService);
                    String key = RpcServiceHelper.buildServiceKey(serviceName, rpcService.version(), rpcService.group());
                    handlerMap.put(key, clazz.newInstance());
                }
            } catch (Exception e) {
                LOGGER.error("scan classes throws exception: {}", e);
            }
        });
        return handlerMap;
    }

    /**
     * Get serviceName
     */
    private static String getServiceName(RpcService rpcService){
        // Use interfaceClass first
        Class clazz = rpcService.interfaceClass();
        if (clazz == void.class){
            return rpcService.interfaceClassName();
        }
        String serviceName = clazz.getName();
        if (serviceName == null || serviceName.trim().isEmpty()){
            serviceName = rpcService.interfaceClassName();
        }
        return serviceName;
    }
}
