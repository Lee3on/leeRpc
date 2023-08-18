package io.lee.rpc.protocol.header;

import io.lee.rpc.common.id.IdFactory;
import io.lee.rpc.constants.RpcConstants;
import io.lee.rpc.protocol.enumeration.RpcType;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Rpc Header Factory
 */
public class RpcHeaderFactory {

    public static RpcHeader getRequestHeader(String serializationType){
        RpcHeader header = new RpcHeader();
        long requestId = IdFactory.getId();
        header.setMagic(RpcConstants.MAGIC);
        header.setRequestId(requestId);
        header.setMsgType((byte) RpcType.REQUEST.getType());
        header.setStatus((byte) 0x1);
        header.setSerializationType(serializationType);
        return header;
    }
}
