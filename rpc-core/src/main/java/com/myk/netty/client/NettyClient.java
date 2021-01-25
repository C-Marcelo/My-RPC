package com.myk.netty.client;

import com.myk.RpcClient;
import com.myk.codec.CommonDecoder;
import com.myk.codec.CommonEncoder;
import com.myk.serializer.JsonSerializer;
import entity.RpcRequest;
import entity.RpcResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author myk
 */
public class NettyClient implements RpcClient {
    private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);
    private String host;
    private int port;
    private static final Bootstrap bootstrap;

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    static {
        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new CommonDecoder())
                                .addLast(new CommonEncoder(new JsonSerializer()))
                                .addLast(new NettyClientHandler());
                    }
                });
    }

    @Override
    public Object sendRequest(RpcRequest rpcRequest) {
        try {
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            logger.info("客户端连接到服务器 {}:{}", host, port);
            Channel channel = channelFuture.channel();
            if(channel != null){
                channel.writeAndFlush(rpcRequest).addListener( future -> {
                    if(future.isSuccess())
                        logger.info(String.format("客户端发送消息: %s", rpcRequest.toString()));
                    else
                        logger.error("发送消息时有错误发生: ", future.cause());
                });
                channel.closeFuture().sync();
                AttributeKey<RpcResponse> key = AttributeKey.valueOf("rpcResponse");
                RpcResponse rpcResponse = channel.attr(key).get();
                return rpcResponse.getData();
            }
        }catch (java.lang.InterruptedException e){
            logger.error("发送消息时错误：" , e);
        }
        return null;
    }
}
