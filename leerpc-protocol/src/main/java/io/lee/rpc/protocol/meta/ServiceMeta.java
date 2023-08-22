package io.lee.rpc.protocol.meta;

import java.io.Serializable;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Service metadata, information registered with the registry
 */
public class ServiceMeta implements Serializable {
    private static final long serialVersionUID = 6289735590272020366L;
    private String serviceName;
    private String serviceVersion;
    private String serviceAddr;
    private int servicePort;
    private String serviceGroup;

    public ServiceMeta() {
    }

    public ServiceMeta(String serviceName, String serviceVersion, String serviceGroup, String serviceAddr, int servicePort) {
        this.serviceName = serviceName;
        this.serviceVersion = serviceVersion;
        this.serviceAddr = serviceAddr;
        this.servicePort = servicePort;
        this.serviceGroup = serviceGroup;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getServiceAddr() {
        return serviceAddr;
    }

    public void setServiceAddr(String serviceAddr) {
        this.serviceAddr = serviceAddr;
    }

    public int getServicePort() {
        return servicePort;
    }

    public void setServicePort(int servicePort) {
        this.servicePort = servicePort;
    }

    public String getServiceGroup() {
        return serviceGroup;
    }

    public void setServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup;
    }
}
