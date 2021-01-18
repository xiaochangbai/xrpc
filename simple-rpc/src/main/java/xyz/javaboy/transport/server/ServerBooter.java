package xyz.javaboy.transport.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import xyz.javaboy.common.RpcRequest;
import xyz.javaboy.common.RpcResponse;
import xyz.javaboy.transport.codec.RpcCustomDecode;
import xyz.javaboy.transport.codec.RpcCustomEncode;
import xyz.javaboy.transport.server.handler.ServerHandler;
import xyz.javaboy.util.AppConst;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
@Slf4j
public class ServerBooter {

    private NioEventLoopGroup bossGroups;
    private NioEventLoopGroup workerGroups;
    private ServerBootstrap bootstrap;

    public ServerBooter(){
        bossGroups = new NioEventLoopGroup(1);
        workerGroups = new NioEventLoopGroup();
        bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroups, workerGroups)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new RpcCustomEncode(RpcResponse.class))
                                .addLast(new RpcCustomDecode(RpcRequest.class))
                                .addLast(new ServerHandler());
                    }
                });
    }


    public void start(int port) throws InterruptedException {
        bootstrap.bind(port).sync();
        log.info("服务器启动完成,port: {}",AppConst.SERVER_PORT);
    }

    public void shutdown(){
        bossGroups.shutdownGracefully();
        workerGroups.shutdownGracefully();
    }

}
