package io.lee.rpc.consumer.common.initializer;

import io.lee.rpc.codec.RpcDecoder;
import io.lee.rpc.codec.RpcEncoder;
import io.lee.rpc.consumer.common.handler.RpcConsumerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Rpc Consumer Initializer
 */
public class RpcConsumerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline cp = channel.pipeline();
        cp.addLast(new RpcEncoder());
        cp.addLast(new RpcDecoder());
        cp.addLast(new RpcConsumerHandler());
    }
}
