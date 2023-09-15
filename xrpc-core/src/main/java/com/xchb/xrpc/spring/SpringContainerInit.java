package com.xchb.xrpc.spring;

import cn.hutool.core.util.StrUtil;
import com.xchb.xrpc.common.AppConst;
import com.xchb.xrpc.register.ServerRegister;
import com.xchb.xrpc.spring.properties.SpringAutoConfigProperties;
import com.xchb.xrpc.transport.server.ServerBooter;
import com.xchb.xrpc.util.SingleFactory;
import com.xchb.xrpc.util.ZkUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringContainerInit implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ServerRegister serverRegister = SingleFactory.getInstance(ServerRegister.class);
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        SpringAutoConfigProperties springAutoConfigProperties
                = applicationContext.getBean(SpringAutoConfigProperties.class);

        AppConst.exportPort = springAutoConfigProperties.getExportPort();
        if(AppConst.exportPort==null) {
            AppConst.exportPort = io.pisceshub.muchat.common.core.utils.MixUtils.findAvailablePort();
        }
        String zkAddr = springAutoConfigProperties.getZkAddr();
        if(StrUtil.isNotBlank(zkAddr)){
            AppConst.zkAddr = zkAddr;
        }
        ZkUtils zkUtils = new ZkUtils(AppConst.zkAddr);
        SingleFactory.set(ZkUtils.class,zkUtils);
        Integer serverCount = serverRegister.serverCount();
        if(serverCount>0){
            try {
                new ServerBooter().start(AppConst.exportPort);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            serverRegister.register();
        }
    }

}
