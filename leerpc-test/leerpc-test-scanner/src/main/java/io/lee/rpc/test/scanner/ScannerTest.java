package io.lee.rpc.test.scanner;

import io.lee.rpc.common.scanner.reference.RpcReferenceScanner;
import io.lee.rpc.common.scanner.ClassScanner;
//import io.lee.rpc.provider.common.scanner.RpcServiceScanner;
import org.junit.Test;

import java.util.List;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Test the scanner of @RpcService annotation
 */
public class ScannerTest {

    /**
     * Scan all the classes under the package io.lee.rpc.test.scanner
     */
    @Test
    public void testScannerClassNameList() throws Exception {
        List<String> classNameList = ClassScanner.getClassNameList("io.lee.rpc.test.scanner", true);
        classNameList.forEach(System.out::println);
    }

    /**
     * Scan all the classes annotated with @RpcService under the package io.lee.rpc.test.scanner
     */
    @Test
    public void testScannerClassNameListByRpcService() throws Exception {
        // RpcServiceScanner.doScannerWithRpcServiceAnnotationFilterAndRegistryService("io.lee.rpc.test.scanner");
    }

    /**
     * Scan all classes annotated with @RpcReference under the package io.lee.rpc.test.scanner
     */
    @Test
    public void testScannerClassNameListByRpcReference() throws Exception {
        RpcReferenceScanner.doScannerWithRpcReferenceAnnotationFilter("io.lee.rpc.test.scanner");
    }
}
