package io.lee.rpc.protocol.request;

import io.lee.rpc.protocol.base.RpcMessage;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Rpc请求封装类，对应的请求id在消息头中
 */
public class RpcRequest extends RpcMessage {
    private static final long serialVersionUID = 5555776886650396129L;

    /**
     * Class name
     */
    private String className;
    /**
     * Method name
     */
    private String methodName;
    /**
     * Parameter type array
     */
    private Class<?>[] parameterTypes;
    /**
     * Parameter array
     */
    private Object[] parameters;
    /**
     * Version
     */
    private String version;
    /**
     * Service group
     */
    private String group;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
