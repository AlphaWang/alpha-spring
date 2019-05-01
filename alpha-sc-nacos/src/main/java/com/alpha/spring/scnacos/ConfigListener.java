package com.alpha.spring.scnacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ConfigListener {
    
    @NacosInjected
    private ConfigService configService;
    
    //TODO 为什么不生效？
    @NacosConfigListener(dataId = "cart_front_api.properties")
    public void onMessage(String config) {
        System.out.println("NACOS UPDATED " + config);
    }
}
