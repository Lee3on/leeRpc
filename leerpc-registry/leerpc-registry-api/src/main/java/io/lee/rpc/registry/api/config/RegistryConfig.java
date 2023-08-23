package io.lee.rpc.registry.api.config;

import java.io.Serializable;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Registry configuration
 */
public class RegistryConfig implements Serializable {
    private static final long serialVersionUID = -7248658103788758893L;
    private String registryAddr;
    private String registryType;

    public RegistryConfig(String registryAddr, String registryType) {
        this.registryAddr = registryAddr;
        this.registryType = registryType;
    }

    public String getRegistryAddr() {
        return registryAddr;
    }

    public void setRegistryAddr(String registryAddr) {
        this.registryAddr = registryAddr;
    }

    public String getRegistryType() {
        return registryType;
    }

    public void setRegistryType(String registryType) {
        this.registryType = registryType;
    }

}
