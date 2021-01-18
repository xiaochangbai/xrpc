package xyz.javaboy.transport.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import xyz.javaboy.common.RpcRequest;
import xyz.javaboy.common.RpcResponse;
import xyz.javaboy.transport.client.handler.ClientHandler;
import xyz.javaboy.transport.codec.RpcCustomDecode;
import xyz.javaboy.transport.codec.RpcCustomEncode;

import java.net.InetSocketAddress;

/**
 * @author XDD
 * @project rpc-demo
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
                .channel(NioSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new RpcCustomEncode(RpcRequest.class))
                                .addLast(new RpcCustomDecode(RpcResponse.class))
                                .addLast(new ClientHandler());
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
