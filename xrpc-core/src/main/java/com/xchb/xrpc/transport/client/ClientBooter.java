package com.xchb.xrpc.transport.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import com.xchb.xrpc.common.RpcRequest;
import com.xchb.xrpc.common.RpcResponse;
import com.xchb.xrpc.transport.client.handler.ClientHandler;
import com.xchb.xrpc.transport.codec.RpcCustomDecode;
import com.xchb.xrpc.transport.codec.RpcCustomEncode;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
@Slf4j
public class ClientBooter {

    private NioEventLoopGroup workerGroups = new NioEventLoopGroup();
    private Bootstrap bootstrap = null;

    public ClientBooter(){
        bootstrap = new Bootstrap();
        bootstrap.group(workerGroups)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,5000)
                .channel(NioSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast("encode",new RpcCustomEncode(RpcRequest.class))
                                .addLast("decode",new RpcCustomDecode(RpcResponse.class))
                                .addLast("client-idle-handler", new IdleStateHandler(30, 0, 0, TimeUnit.SECONDS))
                                .addLast("handler",new ClientHandler());
                    }
                });
        log.info("客户端连接成功");
    }

    public Channel channel(InetSocketAddress inetSocketAddress) throws InterruptedException {
        return bootstrap.connect(inetSocketAddress).sync().channel();
    }

   public void shutdown(){
        if(this.workerGroups!=null){
            this.workerGroups.shutdownGracefully();
        }
   }

}
